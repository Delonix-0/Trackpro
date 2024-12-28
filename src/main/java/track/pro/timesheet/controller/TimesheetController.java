package track.pro.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import track.pro.task.entites.Task;
import track.pro.timesheet.entities.Timesheet;
import track.pro.timesheet.services.TimesheetService;
import track.pro.user.entites.User;

@Controller
@RequestMapping("/timesheet")
public class TimesheetController {

	@Autowired
	private TimesheetService timesheetService;

	@GetMapping("/openTimesheetPage")
	public String openTimesheetPage(Model model) {

		List<Task> listOfTasks = timesheetService.getAllTasks();

		model.addAttribute("listOfTasks", listOfTasks);

		List<User> listOfUsers = timesheetService.getAllUsers();

		model.addAttribute("listOfUsers", listOfUsers);

		return "timesheet/timesheet";
	}

	@PostMapping("/fillTimesheet")
	public String fillTimeSheet(@ModelAttribute Timesheet timesheet, Model model) {
		try {
			System.out.println("Received timesheet data: " + timesheet);
			timesheetService.fillTimesheet(timesheet);
			model.addAttribute("message", "Timesheet filled successfully!");
			return "redirect:/timesheet/openTimesheetPage?success";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error filling timesheet: " + e.getMessage());
			return "error";
		}
	}
}