package com.example.foodapp;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.foodapp.model.Cuisine;
import com.example.foodapp.repositories.CuisineRepository;

@SpringBootApplication
public class FoodRecommendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodRecommendAppApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(CuisineRepository repository) {
		return args -> {
			repository.save(new Cuisine("Korean"));
			repository.save(new Cuisine("Thai"));
			repository.save(new Cuisine("Vietnamese"));
			repository.save(new Cuisine("Japanese"));
			repository.save(new Cuisine("Indonesian"));
			repository.save(new Cuisine("Colombian"));
			repository.save(new Cuisine("Mexican"));
			repository.save(new Cuisine("Turkish"));
		};
	

	}
}
