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

import com.example.foodapp.model.Cuisine;
import com.example.foodapp.repositories.CuisineRepository;


@RestController
@RequestMapping("/api")
public class CuisineController {

	@Autowired
	CuisineRepository cuisineRepository;
	
	@GetMapping("/cuisines")
	public ResponseEntity<List<Cuisine>> getAllCuisines(@RequestParam(required = false) String cuisineName) {
		try {
			List<Cuisine> cuisines = new ArrayList<Cuisine>();

			if (cuisineName == null)
				cuisineRepository.findAll().forEach(cuisines::add);
			else //findBy
				cuisineRepository.findByCuisineName(cuisineName).forEach(cuisines::add);

			if (cuisines.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(cuisines, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
