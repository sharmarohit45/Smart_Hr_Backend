package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AdminEventDao;
import com.youtube.jwt.entity.AdminEvent;
import com.youtube.jwt.entity.AdminLeave;

@Service
public class AdminEventService {
	@Autowired
	private AdminEventDao adminEventDao;
	
	public AdminEvent saveEvent(AdminEvent adminEvent) {
		return adminEventDao.save(adminEvent);
	}
	public List<AdminEvent> getAllEvent() {
		return adminEventDao.findAll();
	}
	public void deleteEvent(Long eventId) {
		AdminEvent existingEvent = adminEventDao.findById(eventId)
				.orElseThrow(() -> new RuntimeException("Event not found"));

		adminEventDao.delete(existingEvent);
	}
}
