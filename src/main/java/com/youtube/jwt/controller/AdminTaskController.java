package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.entity.AdminTask;
import com.youtube.jwt.entity.Appericiation;
import com.youtube.jwt.entity.Project;
import com.youtube.jwt.exception.EntityNotFoundException;
import com.youtube.jwt.service.AdminTaskService;

@RestController
public class AdminTaskController {

	@Autowired
	private AdminTaskService adminTaskService;

	@GetMapping("/task")
	public List<AdminTask> getAllTask() {
		return adminTaskService.getAllTask();
	}

	@PostMapping("/createTask")
	public ResponseEntity<AdminTask> createTask(@RequestBody AdminTask adminTask) {
		AdminTask adminTaskSave = adminTaskService.savetask(adminTask);
		return new ResponseEntity<>(adminTaskSave, HttpStatus.CREATED);
	}

    @GetMapping("/task/{id}")
    public ResponseEntity<AdminTask> getTaskById(@PathVariable("id") Long id) {
        return adminTaskService.getTaskById(id)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	@DeleteMapping("/task/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
		try {
			adminTaskService.deleteTask(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
    
}
