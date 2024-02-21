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

import com.example.foodapp.model.Recipes;
import com.example.foodapp.model.User;
import com.example.foodapp.repositories.RecipesRepository;
import com.example.foodapp.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class RecipesController {
	@Autowired
	RecipesRepository recipesRepository;
	
	@GetMapping("/recipes")
	public ResponseEntity<List<Recipes>> getAllRecipes() {
		try {
			List<Recipes> recipes = new ArrayList<Recipes>();
			
			recipesRepository.findAll().forEach(recipes::add);
			
			return new ResponseEntity<>(recipes, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
