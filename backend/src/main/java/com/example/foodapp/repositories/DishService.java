package com.example.foodapp.repositories;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodapp.model.Cuisine;
import com.example.foodapp.model.Dish;
import com.example.foodapp.model.Mood;
import com.example.foodapp.model.Recipes;

@Service
public class DishService {
	@Autowired
    private DishRepository dishRepository;

	@Autowired
	private MoodRepository moodRepository;
	
	@Autowired
	private CuisineRepository cuisineRepository;

    public Set<Recipes> getRecipeByDish(Long dishId) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        return dish.map(Dish::getRecipes).orElse(null);
    }
    public List<Dish> getDishesByMoodAndCuisine(Long moodId, Long cuisineId) {
        return dishRepository.findByMoodMoodIdAndCuisineCuisineId(moodId, cuisineId);
    }
    
    public List<Dish> getDishesByMoodAndCuisine(Mood mood, Cuisine cuisine) {
        return dishRepository.findByMoodAndCuisine(mood, cuisine);
    }

}
