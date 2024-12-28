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
		
		// fetching tasks from database
		List<Task> listOfTasks = taskService.getAllTasks();
		System.out.println(listOfTasks);
		// fetching projects from database
		List<Project> listOfProjects = taskService.getAllProjects();
		System.out.println(listOfProjects);
		// fetching users from database
		List<User> listOfUsers = taskService.getAllUsers();
		System.out.println(listOfUsers);

		// send to project.jsp
		model.addAttribute("listOfTasks", listOfTasks);
		model.addAttribute("listOfProjects", listOfProjects);
		model.addAttribute("listOfUsers", listOfUsers);

		return "task/task";
	}
	

	@PostMapping("/updateTask")
	public String updateTask(@ModelAttribute Task task, Model model) {
	    try {
	    	System.out.println(task);
	        // Fetch the existing task from the database
	        Task existingTask = taskService.getTaskById(task.getTaskId());
	        System.out.println(existingTask);
	        // Update only the specified fields
	        existingTask.setStartTime(task.getStartTime());
	        existingTask.setCompTime(task.getCompTime());
	        existingTask.setDuration(task.getDuration());

	        // Save the updated task
	        taskService.updateTask(existingTask);
	        return "redirect:/task/openTaskPage?success";
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	        model.addAttribute("errorMessage", "Error updating task: " + e.getMessage());
	        return "error";
	    }
	}
	
	
	

}
