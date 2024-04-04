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
import com.example.foodapp.model.Mood;
import com.example.foodapp.model.Recipes;
import com.example.foodapp.model.User;
import com.example.foodapp.repositories.CuisineRepository;
import com.example.foodapp.repositories.DishRepository;
import com.example.foodapp.repositories.DishService;
import com.example.foodapp.repositories.MoodRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DishController {
	
	@Autowired
	DishRepository dishRepository;
	
	@GetMapping("/dishes")
	public ResponseEntity<List<Dish>> getDishesByMoodAndCuisine(
	    @RequestParam(required = false) Long moodId,
	    @RequestParam(required = false) Long cuisineId
	) {
	    try {
	        List<Dish> dishes = new ArrayList<>();

	        if (moodId != null && cuisineId != null) {
	            // Fetch dishes based on moodId and cuisineId
	            dishes = dishService.getDishesByMoodAndCuisine(moodId, cuisineId);
	        } else {
	            // If moodId and cuisineId are not specified, return all dishes
	            dishRepository.findAll().forEach(dishes::add);
	        }

	        if (dishes.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(dishes, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	@Autowired
    private DishService dishService;

    @GetMapping("/dishes/{dishId}/recipes")
    public ResponseEntity<Set<Recipes>> getRecipeByDish(@PathVariable Long dishId) {
        Set<Recipes> recipe = dishService.getRecipeByDish(dishId);
        return ResponseEntity.ok(recipe);
    }
    
    @GetMapping("/dishes/{dishId}")
	public ResponseEntity<Dish> getDishById(@PathVariable Long dishId) {
	    try {
	    	Optional<Dish> dishData = dishRepository.findById(dishId);

	        if (dishData.isPresent()) {
	            return new ResponseEntity<>(dishData.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
    
    


}
