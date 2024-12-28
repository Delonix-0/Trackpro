package track.pro.timesheet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import track.pro.task.entites.Task;
import track.pro.timesheet.entities.Timesheet;
import track.pro.timesheet.repository.TimesheetRepository;


import track.pro.user.entites.User;

@Service
public class TimesheetServiceImpl implements TimesheetService {
	
	@Autowired
	TimesheetRepository timesheetRepository;

	@Override
	public int fillTimesheet(Timesheet timesheet) {
		return timesheetRepository.fillTimesheet(timesheet) ;
	}

	@Override
	public List<Task> getAllTasks() {
		return timesheetRepository.fetchAllTasks();
	}

	@Override
	public List<User> getAllUsers() {
		return timesheetRepository.fetchAllUsers();
	}
	
}
