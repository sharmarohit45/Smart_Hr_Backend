package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.InterviewDao;
import com.youtube.jwt.entity.InterviewSchedule;

@Service
public class InterviewService {
@Autowired
private InterviewDao interviewDao;
public InterviewSchedule saveInterviewSchedule(InterviewSchedule interviewSchedule) {
	return interviewDao.save(interviewSchedule);
}

public List<InterviewSchedule> getAllInterviewSchedule() {
	return interviewDao.findAll();
}
public Optional<InterviewSchedule> getInterviewScheduleById(Long id) {
    return interviewDao.findById(id);
}
public Optional<InterviewSchedule> getInterviewById(Long id) {
    return interviewDao.findById(id);
}
public InterviewSchedule updateInterview(Long id, InterviewSchedule interviewSchedule) {
    Optional<InterviewSchedule> existingInterviewOptional = interviewDao.findById(id);
    if (existingInterviewOptional.isPresent()) {
        InterviewSchedule existingInterview = existingInterviewOptional.get();
        existingInterview.setJob(interviewSchedule.getJob());
        existingInterview.setCandidate(interviewSchedule.getCandidate());
        existingInterview.setInterviewer(interviewSchedule.getInterviewer());
        existingInterview.setStartDate(interviewSchedule.getStartDate());
        existingInterview.setRound(interviewSchedule.getRound());
        existingInterview.setInterviewType(interviewSchedule.getInterviewType());
        existingInterview.setStartTime(interviewSchedule.getStartTime());
        existingInterview.setInterviewerComment(interviewSchedule.getInterviewerComment());
        existingInterview.setNotifyCandidate(interviewSchedule.getNotifyCandidate());
        existingInterview.setCandidateComment(interviewSchedule.getCandidateComment());
        existingInterview.setSendReminder(interviewSchedule.getSendReminder());
        existingInterview.setStatus(interviewSchedule.getStatus());
        
        return interviewDao.save(existingInterview);
    } else {
        throw new RuntimeException("InterviewSchedule not found with id " + id);
    }
}
public void deleteInterviewSchedule(Long id) {
	interviewDao.deleteById(id);
}
}
