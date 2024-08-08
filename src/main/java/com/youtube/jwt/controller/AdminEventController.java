package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.AdminEvent;
import com.youtube.jwt.service.AdminEventService;

@RestController
public class AdminEventController {
	@Autowired
	private AdminEventService adminEventService;
	
	@PostMapping("/events")
	public ResponseEntity<AdminEvent> saveEvent(@RequestBody AdminEvent adminEvent)
	{
	    AdminEvent saveEvent = adminEventService.saveEvent(adminEvent);
	    return ResponseEntity.ok(saveEvent);
	}
	@GetMapping("/events")
	public List<AdminEvent> getAllEvents() {
	    return adminEventService.getAllEvent();
	}
	@DeleteMapping("/events/{eventId}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long eventId) {
		adminEventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }
}
