package com.example.foodapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodapp.model.Dish;
import com.example.foodapp.model.User;
import com.example.foodapp.model.UserPreferences;
import com.example.foodapp.repositories.MoodService;
import com.example.foodapp.repositories.UserPreferencesRepository;
import com.example.foodapp.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserPreferencesController {
	@Autowired
	UserPreferencesRepository preferencesRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users/{id}/userPreferences")
    public ResponseEntity<List<UserPreferences>> getUserPreferencesByUserId(@PathVariable("id") long userId) {
        try {
            Optional<User> userData = userRepository.findById(userId);
            if (userData.isPresent()) {
                List<UserPreferences> preferences = preferencesRepository.findByUser(userData.get());
                return new ResponseEntity<>(preferences, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
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
