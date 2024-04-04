package com.example.foodapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodapp.model.Cuisine;
import com.example.foodapp.model.Dish;
import com.example.foodapp.model.Mood;

public interface DishRepository extends JpaRepository<Dish, Long>{
	
	List<Dish> findByDishName(String dishName);

    List<Dish> findByCuisine_CuisineName(String cuisineName);

    List<Dish> findByMood_MoodName(String moodName);
    
    List<Dish> findByIngredients(String ingredients);
    
    List<Dish> findByMoodMoodIdAndCuisineCuisineId(Long moodId, Long cuisineId);
    
    List<Dish> findByMoodAndCuisine(Mood mood, Cuisine cuisine);


}
