package com.example.foodapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodapp.model.FeedBack;
import com.example.foodapp.model.UserFavorites;
import com.example.foodapp.repositories.FeedbackRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FeedBackController {

	@Autowired
	FeedbackRepository feedbackRepository;

	@GetMapping("/FeedBack")
	public ResponseEntity<List<FeedBack>> getAllUserFeedBack() {

		try {
			List<FeedBack> feedback1 = new ArrayList<FeedBack>();

			feedbackRepository.findAll().forEach(feedback1::add);
			return new ResponseEntity<>(feedback1, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	  @PostMapping("/FeedBack")
	    public ResponseEntity<String> createFeedBack(@RequestBody FeedBack newFeedback) {
	        try {
	           
	        	feedbackRepository.save(newFeedback);
	            return new ResponseEntity<>("Feedback saved successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
