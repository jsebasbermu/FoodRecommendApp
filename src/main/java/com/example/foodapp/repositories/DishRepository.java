package com.example.foodapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodapp.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Long>{
	
	List<Dish> findByDishName(String dishName);

    List<Dish> findByCuisine_CuisineName(String cuisineName);

    List<Dish> findByMood_MoodName(String moodName);
    
    List<Dish> findByIngredients(String ingredients);

}
