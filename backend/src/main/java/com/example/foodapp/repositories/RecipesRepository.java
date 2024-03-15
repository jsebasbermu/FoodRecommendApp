package com.example.foodapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodapp.model.Recipes;

public interface RecipesRepository extends JpaRepository<Recipes, Long>{

}
