package com.youtube.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InterviewSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long interviewId;
	
	private String job;
	private String candidate;
	private String interviewer;
	private String startDate;
	private String round;
	private String interviewType;
	private String startTime;
	private String interviewerComment;
	private String notifyCandidate;
	private String candidateComment;
	private String sendReminder;
	private String status;
	public long getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(long interviewId) {
		this.interviewId = interviewId;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public String getInterviewer() {
		return interviewer;
	}
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getRound() {
		return round;
	}
	public void setRound(String round) {
		this.round = round;
	}
	public String getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getInterviewerComment() {
		return interviewerComment;
	}
	public void setInterviewerComment(String interviewerComment) {
		this.interviewerComment = interviewerComment;
	}
	public String getNotifyCandidate() {
		return notifyCandidate;
	}
	public void setNotifyCandidate(String notifyCandidate) {
		this.notifyCandidate = notifyCandidate;
	}
	public String getCandidateComment() {
		return candidateComment;
	}
	public void setCandidateComment(String candidateComment) {
		this.candidateComment = candidateComment;
	}
	public String getSendReminder() {
		return sendReminder;
	}
	public void setSendReminder(String sendReminder) {
		this.sendReminder = sendReminder;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
