package track.pro.timesheet.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import track.pro.task.entites.Task;
import track.pro.timesheet.entities.Timesheet;
import track.pro.user.entites.User;

@Repository
public class TimesheetRepositoryImpl implements TimesheetRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int fillTimesheet(Timesheet timesheet) {
    	final String INSERT_TIMESHEETS = "INSERT INTO timesheets (task_id, user_id, date, hours_logged,"
    			+ " created_at) "
    			+ "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(INSERT_TIMESHEETS, timesheet.getTaskId(), timesheet.getUserId(), timesheet.getDate(),
                                   timesheet.getHoursLogged(), timesheet.getCreatedAt());
                                   
    }

	@Override
	public List<Task> fetchAllTasks() {
		final String GET_ALL_TASKS = "SELECT * FROM tasks";
		 
		return jdbcTemplate.query(GET_ALL_TASKS, (rs, rowNum) -> {
			int taskId = rs.getInt("task_id");
			String title=rs.getString("title");
			return new Task(taskId,title);
		});
	}

	@Override
	public List<User> fetchAllUsers() {
		final String GET_ALL_USERS = "SELECT * FROM trackpro.users where role_id=3";
		return jdbcTemplate.query(GET_ALL_USERS, (rs, rowNum) -> {
			int userId = rs.getInt("user_id");
			String fullName = rs.getString("full_name");
			return new User(userId, fullName);
		});
	}
}