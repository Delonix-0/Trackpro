package track.pro.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import track.pro.project.entites.Project;
import track.pro.task.entites.Task;
import track.pro.task.services.TaskService;
import track.pro.user.entites.User;


@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/openTaskPage")
	public String openTaskPage(Model model) {
		// fetching projects from database
		
		List<Task> listOfTasks = taskService.getAllTasks();
		List<Project> listOfProjects = taskService.getAllProjects();
		List<User> listOfUsers = taskService.getAllUsers();


		// send to project.jsp
		
		model.addAttribute("listOfTasks", listOfTasks);
		model.addAttribute("listOfProjects", listOfProjects);
		model.addAttribute("listOfUsers", listOfUsers);


		return "task/task";
	}
	
	@PostMapping("/task")
	public String task(@ModelAttribute Task task, Model model) {
		try {
			taskService.fillTask(task);
			return "redirect:/task/openTaskPage?success";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error adding task: " + e.getMessage());
			return "error";
		}
	}
	
	
	

}
