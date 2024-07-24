package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.AdminTask;
import com.youtube.jwt.entity.AssetsData;
import com.youtube.jwt.service.Assets;

@RestController
public class AssetsController {
	@Autowired
	private Assets assetsService;

	@PostMapping("/assets")
	public ResponseEntity<AssetsData> createTask(@RequestBody AssetsData assetsData) {
		AssetsData adminTaskSave = assetsService.saveAssets(assetsData);
		return new ResponseEntity<>(adminTaskSave, HttpStatus.CREATED);
	}

	@GetMapping("/assets")
	public List<AssetsData> getAllAssets() {
		return assetsService.getAllAssets();
	}
}
