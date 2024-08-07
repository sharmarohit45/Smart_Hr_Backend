package com.youtube.jwt.controller;

import java.util.List;

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
import com.youtube.jwt.entity.Skills;
import com.youtube.jwt.service.SkillsService;

@RestController
public class SkillsController {
@Autowired
private SkillsService skillsService;

@PostMapping("/skills")
public ResponseEntity<Skills> createTask(@RequestBody Skills skills) {
	Skills skillsSave = skillsService.postSkills(skills);
	return new ResponseEntity<>(skillsSave, HttpStatus.CREATED);
}

@GetMapping("/skills")
public List<Skills> getAllSkills() {
	return skillsService.getAllSkills();
}
@PutMapping("/skills/{skillId}")
public ResponseEntity<Skills> updateSkills(@PathVariable Long skillId, @RequestBody Skills skills) {
	Skills skillsData = skillsService.updateSkills(skillId, skills);
    return ResponseEntity.ok(skillsData);
}
@DeleteMapping("/skills/{skillId}")
public ResponseEntity<Void> deleteSkills(@PathVariable Long skillId) {
	skillsService.deleteSkills(skillId);
    return ResponseEntity.noContent().build();
}

}
