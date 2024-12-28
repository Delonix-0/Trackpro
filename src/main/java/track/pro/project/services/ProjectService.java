package track.pro.project.services;

import java.util.List;

import track.pro.project.entites.Project;
import track.pro.user.entites.User;

public interface ProjectService {

	int insertProject(Project project);

	//List<Project> getAllProjects();
	
	List<User> getAllUsers();
}