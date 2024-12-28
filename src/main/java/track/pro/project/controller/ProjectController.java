package track.pro.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import track.pro.project.entites.Project;
import track.pro.project.services.ProjectService;
import track.pro.user.entites.User;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@GetMapping("/openProjectPage")
	public String openProjectPage(Model model) {
		// fetching projects from database
		List<User> listOfUsers = projectService.getAllUsers();

		// send to project.jsp
		model.addAttribute("listOfUsers", listOfUsers);

		return "project/project";
	}

	@PostMapping("/project")
	public String project(@ModelAttribute Project project, Model model) {
		try {
			projectService.insertProject(project);
			return "redirect:/project/openProjectPage?success";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error adding project: " + e.getMessage());
			return "error";
		}
	}
}