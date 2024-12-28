package track.pro.timesheet.entities;

//`timesheet_id`, `task_id`, `full_name`, `date`, `hours_logged`, `status`, `created_at`, `updated_at`

public class Timesheet {

    private int timesheetId;
    private int taskId;
    private int userId;
    private String date;
    private Double hoursLogged;
    private boolean status;
    private String createdAt;
    private String updatedAt;
	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Timesheet(int timesheetId, int taskId, int userId, String date, Double hoursLogged, boolean status,
			String createdAt, String updatedAt) {
		super();
		this.timesheetId = timesheetId;
		this.taskId = taskId;
		this.userId = userId;
		this.date = date;
		this.hoursLogged = hoursLogged;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public int getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getHoursLogged() {
		return hoursLogged;
	}
	public void setHoursLogged(Double hoursLogged) {
		this.hoursLogged = hoursLogged;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Timesheet [timesheetId=" + timesheetId + ", taskId=" + taskId + ", userId=" + userId + ", date=" + date
				+ ", hoursLogged=" + hoursLogged + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	    }