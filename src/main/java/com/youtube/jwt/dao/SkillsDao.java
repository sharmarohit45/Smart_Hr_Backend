package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Skills;

@Repository
public interface SkillsDao extends JpaRepository<Skills,Long> {

}
