package com.example.foodapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodapp.model.Dish;
import com.example.foodapp.model.Mood;
import com.example.foodapp.repositories.MoodRepository;
import com.example.foodapp.repositories.MoodService;

import jakarta.persistence.EntityNotFoundException;

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
	
	@GetMapping("/moods/{id}")
    public ResponseEntity<Mood> getMoodsByMoodId(@PathVariable("id") Long id) {
        Optional<Mood> moods = moodRepository.findById(id);
        if(moods.isPresent()) {
			// Status okay is the course is found
			return new ResponseEntity<>(moods.get(), HttpStatus.OK);
		}
		// status no content if it is not found the course.
		return new ResponseEntity<>(moods.get(), HttpStatus.NO_CONTENT);
    }
	
	@Autowired
    private MoodService moodService;

    @GetMapping("/moods/{moodId}/dishes")
    public ResponseEntity<Set<Dish>> getDishesByMood(@PathVariable Long moodId) {
    	try {
            Set<Dish> dishes = moodService.getDishesByMood(moodId);
            return new ResponseEntity<>(dishes, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
