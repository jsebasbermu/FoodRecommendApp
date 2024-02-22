package com.example.foodapp.repositories;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodapp.model.Cuisine;
import com.example.foodapp.model.Dish;

@Service
public class CuisineService {
	@Autowired
    private CuisineRepository cuisineRepository;

	public Set<Dish> getDishesByCuisine(Long cuisineId) {
        Optional<Cuisine> cuisine = cuisineRepository.findById(cuisineId);
        return cuisine.map(Cuisine::getDishes).orElse(Collections.emptySet());
    }
}
