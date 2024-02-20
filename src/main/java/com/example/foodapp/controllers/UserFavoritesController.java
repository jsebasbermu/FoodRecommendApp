package com.example.foodapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodapp.model.UserFavorites;
import com.example.foodapp.repositories.FavoritesRepository;

@RestController
@RequestMapping("/api")
public class UserFavoritesController {

	@Autowired
	FavoritesRepository favoritesRepository;
	
	@GetMapping("/userfavorites")
	public ResponseEntity<List<UserFavorites>> getAllFavorites() {
		
		try {
			List<UserFavorites> favorites1 = new ArrayList<UserFavorites>();
			
			favoritesRepository.findAll().forEach(favorites1::add);
			return new ResponseEntity<>(favorites1, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
