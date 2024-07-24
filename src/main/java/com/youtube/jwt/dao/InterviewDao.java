package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.InterviewSchedule;

@Repository
public interface InterviewDao extends JpaRepository<InterviewSchedule, Long>{

}
