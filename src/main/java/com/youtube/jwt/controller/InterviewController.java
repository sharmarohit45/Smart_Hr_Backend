package com.youtube.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.youtube.jwt.entity.InterviewSchedule;
import com.youtube.jwt.service.InterviewService;

@RestController
public class InterviewController {
	@Autowired
	private InterviewService interviewService;

	@PostMapping("/interview")
	public ResponseEntity<InterviewSchedule> saveInterviewSchedule(@RequestBody InterviewSchedule InterviewSchedule) {
		InterviewSchedule saveInterviewSchedule = interviewService.saveInterviewSchedule(InterviewSchedule);
		return ResponseEntity.ok(saveInterviewSchedule);
	}

	@GetMapping("/interview")
	public List<InterviewSchedule> getAllInterviewSchedule() {
		return interviewService.getAllInterviewSchedule();
	}
	@GetMapping("/interview/{id}")
    public ResponseEntity<InterviewSchedule> getInterviewById(@PathVariable Long id) {
        Optional<InterviewSchedule> interview = interviewService.getInterviewById(id);
        return interview.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	@PutMapping("/interview/{id}")
	public ResponseEntity<InterviewSchedule> updateInterviewSchedule(@PathVariable Long id, @RequestBody InterviewSchedule interviewSchedule) {
	    try {
	        InterviewSchedule updatedInterviewSchedule = interviewService.updateInterview(id, interviewSchedule);
	        return new ResponseEntity<>(updatedInterviewSchedule, HttpStatus.OK);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
	    }
	}

	@DeleteMapping("/interview/{id}")
	public ResponseEntity<Void> deleteInterviewSchedule(@PathVariable Long id) {
		Optional<InterviewSchedule> interviewSchedule = interviewService.getInterviewScheduleById(id);
		if (interviewSchedule.isPresent()) {
			interviewService.deleteInterviewSchedule(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
