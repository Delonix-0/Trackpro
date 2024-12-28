package track.pro.timesheet.repository;
 
import java.util.List;

import track.pro.task.entites.Task;
import track.pro.timesheet.entities.Timesheet;
import track.pro.user.entites.User;

 
public interface TimesheetRepository {
	
	int fillTimesheet(Timesheet timesheet);
	
	List<Task> fetchAllTasks();
	
	List<User> fetchAllUsers();
 
}