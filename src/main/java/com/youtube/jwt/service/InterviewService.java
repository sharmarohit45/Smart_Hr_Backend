package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.InterviewDao;
import com.youtube.jwt.entity.Designations;
import com.youtube.jwt.entity.InterviewSchedule;

@Service
public class InterviewService {
@Autowired
private InterviewDao interviewDao;
public InterviewSchedule saveInterviewSchedule(InterviewSchedule interviewSchedule) {
	return interviewDao.save(interviewSchedule);
}

public List<InterviewSchedule> getAllInterviewSchedule() {
	return interviewDao.findAll(); // Or whatever method is used in your DAO
}
public Optional<InterviewSchedule> getInterviewScheduleById(Long id) {
    return interviewDao.findById(id);
}

public void deleteInterviewSchedule(Long id) {
	interviewDao.deleteById(id);
}
}
