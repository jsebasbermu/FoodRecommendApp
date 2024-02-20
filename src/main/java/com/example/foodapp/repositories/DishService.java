package com.example.foodapp.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodapp.model.Dish;

@Service
public class DishService {

	@Autowired
	DishRepository dishRepository;

	public List<Dish> getDishesByMoodName(String moodName) {
		// Implement logic to fetch dishes by mood from the repository
		return dishRepository.findByMood_MoodName(moodName);
	}

}
