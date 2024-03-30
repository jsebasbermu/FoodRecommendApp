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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodapp.model.Cuisine;
import com.example.foodapp.model.Dish;
import com.example.foodapp.model.UserPreferences;
import com.example.foodapp.repositories.CuisineRepository;
import com.example.foodapp.repositories.CuisineService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/cuisines")
public class CuisineController {

	@Autowired
	CuisineRepository cuisineRepository;

	@GetMapping
    public ResponseEntity<List<Cuisine>> getAllCuisines(@RequestParam(required = false) String cuisineName) {
        try {
            List<Cuisine> cuisines = new ArrayList<>();

            if (cuisineName == null)
                cuisineRepository.findAll().forEach(cuisines::add);
            else
                cuisineRepository.findByCuisineName(cuisineName).forEach(cuisines::add);

            if (cuisines.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cuisines, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


	// Get all dishes of a cuisine by cuisine ID
	@GetMapping("/{id}/dishes")
    public ResponseEntity<Set<Dish>> getDishesByCuisineId(@PathVariable Long id) {
        try {
            Optional<Cuisine> cuisineData = cuisineRepository.findById(id);
            return cuisineData.map(cuisine -> new ResponseEntity<>(cuisine.getDishes(), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get all user preferences of a cuisine by cuisine ID
	@GetMapping("/{id}/userPreferences")
    public ResponseEntity<Set<UserPreferences>> getUserPreferencesByCuisineId(@PathVariable Long id) {
        try {
            Optional<Cuisine> cuisineData = cuisineRepository.findById(id);
            return cuisineData.map(cuisine -> new ResponseEntity<>(cuisine.getUserPreferences(), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
