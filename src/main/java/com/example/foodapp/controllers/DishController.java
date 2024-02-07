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


import com.example.foodapp.model.Dish;
import com.example.foodapp.repositories.DishRepository;

@RestController
@RequestMapping("/api")
public class DishController {
	
	@Autowired
	DishRepository dishRepository;
	
	@GetMapping("/dishes")
	public ResponseEntity<List<Dish>> getAllCuisines(@RequestParam(required = false) String dishName) {
		try {
			List<Dish> dishes = new ArrayList<Dish>();

			if (dishName == null)
				dishRepository.findAll().forEach(dishes::add);
			else //findBy
				dishRepository.findByDishName(dishName).forEach(dishes::add);

			if (dishes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(dishes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
