package com.example.foodapp;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.foodapp.model.Cuisine;
import com.example.foodapp.model.Mood;
import com.example.foodapp.model.User;
import com.example.foodapp.repositories.CuisineRepository;
import com.example.foodapp.repositories.MoodRepository;
import com.example.foodapp.repositories.UserRepository;

@SpringBootApplication
public class FoodRecommendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodRecommendAppApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CuisineRepository cuisineRepository , MoodRepository moodRepository, UserRepository userRepository) {
		return args -> {
			cuisineRepository.save(new Cuisine("Korean"));
			cuisineRepository.save(new Cuisine("Thai"));
			cuisineRepository.save(new Cuisine("Vietnamese"));
			cuisineRepository.save(new Cuisine("Japanese"));
			cuisineRepository.save(new Cuisine("Indonesian"));
			cuisineRepository.save(new Cuisine("Colombian"));
			cuisineRepository.save(new Cuisine("Turkish"));
			
			moodRepository.save(new Mood("Stressed",
					"Feeling pressure or tension, " + "often due to challenging situations or demands."));
			moodRepository.save(new Mood("Angry", "Experiencing strong displeasure or "
					+ "irritation, often in response to perceived injustice or frustration."));
			moodRepository.save(new Mood("Sad",
					"Feeling sorrow or unhappiness, typically " + "in response to loss or disappointment."));
			moodRepository.save(new Mood("Bored", "Experiencing a lack of interest or stimulation, "
					+ "leading to feelings of tedium or restlessness."));
			moodRepository.save(new Mood("Hungry", "Feeling a simple physical " + "need for food due to an empty stomach"));
			moodRepository.save(new Mood("Happy",
					"Experiencing joy, contentment, or positive " + "feelings that bring a sense of well-being."));
			moodRepository.save(new Mood("Celebration", "Feeling a heightened sense of joy or happiness, "
					+ "often associated with special occasions or positive events."));
			moodRepository.save(new Mood("Loved", "Experiencing a deep affection and connection with others, "
					+ "often associated with feelings of warmth and care."));
		
			//Test adding users
			userRepository.save(new User("Sebastian Bermudez", "seb123456"));		
			userRepository.save(new User("Russell", "rus678_99"));		
			userRepository.save(new User("Burak", "burak12974_"));		
			userRepository.save(new User("Valentina Alvarez", "Valen12345_"));		

		} ;
		
		
		
	}
}
