package track.pro.task.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import track.pro.project.entites.Project;
import track.pro.task.entites.Task;
import track.pro.user.entites.User;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public int fillTask(Task task) {
		final String INSERT_TASK = "INSERT INTO tasks(`task_id`,`start_time`,`comp_time`,`duration`,`assigned_to`,`project_id`) VALUES"
				+ "(?,?,?,?,?,?)";
		return jdbcTemplate.update(INSERT_TASK, task.getTaskId(), task.getStartTime(), task.getCompTime(),
				task.getDuration(),task.getAssignedTo() ,task.getProjectId());
	}

	@Override
	public List<Task> fetchAllTasks() {
		final String GET_ALL_TASKS = "SELECT * FROM tasks";

		return jdbcTemplate.query(GET_ALL_TASKS, (rs, rowNum) -> {
			int taskId = rs.getInt("task_id");
			String title = rs.getString("title");
			return new Task(taskId, title);
		});
	}

	@Override
	public List<Project> fetchAllProjects() {
		final String GET_ALL_PROJECTS = "SELECT * FROM projects";

		return jdbcTemplate.query(GET_ALL_PROJECTS, (rs, rowNum) -> {
			int projectId = rs.getInt("project_id");
			String projectName = rs.getString("project_name");
			return new Project(projectId, projectName);
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
