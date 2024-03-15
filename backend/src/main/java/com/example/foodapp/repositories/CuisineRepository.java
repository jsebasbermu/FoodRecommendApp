package com.example.foodapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodapp.model.Cuisine;


public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
	
	List<Cuisine> findByCuisineName(String cuisineName);

}
