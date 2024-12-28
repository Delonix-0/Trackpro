package track.pro.task.services;

import java.util.List;

import track.pro.project.entites.Project;
import track.pro.task.entites.Task;
import track.pro.user.entites.User;

public interface TaskService {
	
	int fillTask(Task task);
	List<Task> getAllTasks();
	List<Project> getAllProjects();
	List<User> getAllUsers();

}
