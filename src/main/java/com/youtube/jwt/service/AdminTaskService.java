package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.youtube.jwt.dao.AdminTaskDao;
import com.youtube.jwt.dao.EmployeeDao;
import com.youtube.jwt.entity.AdminTask;
import com.youtube.jwt.entity.Appericiation;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.exception.EntityNotFoundException;


@Service
public class AdminTaskService {

	@Autowired
	private AdminTaskDao adminTaskDao;

	@Autowired
	private EmployeeDao employeeDao;

	public AdminTask savetask(AdminTask adminTask) {
		Employee employee = employeeDao.findById(adminTask.getAssignedTo())
				.orElseThrow(() -> new RuntimeException("Employee not found"));
		adminTask.setEmployee(employee);
		AdminTask savedAdminTask = adminTaskDao.save(adminTask);
		return savedAdminTask;
	}

	public List<AdminTask> getAllTask() {
		return adminTaskDao.findAll();
	}
	public Optional<AdminTask> getTaskById(Long id) {
		return adminTaskDao.findById(id);
	}
	public void deleteTask(Long id) {
        Optional<AdminTask> task = adminTaskDao.findById(id);
        if (task.isPresent()) {
        	adminTaskDao.deleteById(id);
        } else {
            throw new EntityNotFoundException("Appericiation with ID " + id + " not found.");
        }
    }



}
