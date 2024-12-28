package track.pro.timesheet.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import track.pro.timesheet.entities.Timesheet;

public class TimesheetRowMapper implements RowMapper<Timesheet>{
	
	//`timesheet_id`, `task_id`, `user_id`, `date`, `hours_logged`, `status`, `created_at`, `updated_at`
	
	@Override
	public Timesheet mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int timesheetId=rs.getInt("timesheet_id");
		int taskId=rs.getInt("task_id");
		int userId=rs.getInt("user_id");
		String date=rs.getString("date");
		Double hoursLogged=rs.getDouble("hours_logged");
		boolean status=rs.getBoolean("status");
		String createdAt=rs.getString("created_at");
		String updatedAt=rs.getString("updated_at");
		
		
		return new Timesheet(timesheetId, taskId, userId, date, hoursLogged, status, createdAt, updatedAt);
	}

}
