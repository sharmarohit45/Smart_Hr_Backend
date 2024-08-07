package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.youtube.jwt.dao.SkillsDao;
import com.youtube.jwt.entity.Skills;

@Service
public class SkillsService {
@Autowired
private SkillsDao skillsDao;
	
	public Skills postSkills(Skills skills) {
	    return skillsDao.save(skills);
	}
	public List<Skills> getAllSkills() {
	    return skillsDao.findAll(); 
	}
	public Optional<Skills> findSkillsById(Long id) {
	    return skillsDao.findById(id);
	}
	public void deleteSkills(Long id) {
		skillsDao.deleteById(id);
    }
	public Skills updateSkills(Long skillId, Skills updatedSkills) {
		Skills existingSkills = skillsDao.findById(skillId)
				.orElseThrow(() -> new RuntimeException("Skills not found with id: " + skillId));
		existingSkills.setSkill(updatedSkills.getSkill());
		return skillsDao.save(existingSkills);
	}
}
