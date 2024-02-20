package com.example.foodapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodapp.model.UserPreferences;
import com.example.foodapp.repositories.UserPreferencesRepository;

@RestController
@RequestMapping("/api")
public class UserPreferencesController {
	@Autowired
	UserPreferencesRepository preferencesRepository;
	
	@GetMapping("/userpreferences")
	public ResponseEntity<List<UserPreferences>> getAllPreferences() {
		
		try {
			List<UserPreferences> preferences = new ArrayList<UserPreferences>();
			
			preferencesRepository.findAll().forEach(preferences::add);
			return new ResponseEntity<>(preferences, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
