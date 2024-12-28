package track.pro.timesheet.services;
 
import java.util.List;


import track.pro.task.entites.Task;
import track.pro.timesheet.entities.Timesheet;
import track.pro.user.entites.User;
 
public interface TimesheetService {
	
	int fillTimesheet(Timesheet timesheet);
	
	List<Task> getAllTasks();
	List<User> getAllUsers();
 
}