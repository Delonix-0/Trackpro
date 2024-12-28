package track.pro.project.repository;

import java.util.List;

import track.pro.project.entites.Project;
import track.pro.user.entites.User;

public interface ProjectRepository {
	int insertProject(Project project);

	//List<Project> fetchAllProjects();
	
	List<User> fetchAllUsers();

}