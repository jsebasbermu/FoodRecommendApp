package com.example.foodapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodapp.model.Mood;
import com.example.foodapp.repositories.MoodRepository;

@RestController
@RequestMapping("/api")
public class MoodController {
	
	@Autowired
	MoodRepository moodRepository;
	
	@GetMapping("/moods")
	public ResponseEntity<List<Mood>> getAllMoods(@RequestParam(required = false) String moodName) {
		try {
			List<Mood> moods = new ArrayList<Mood>();

			if (moodName == null)
				moodRepository.findAll().forEach(moods::add);
			else //findBy
				moodRepository.findByMoodName(moodName).forEach(moods::add);

			if (moods.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(moods, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
