package com.example.foodapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodapp.model.UserFavorites;

public interface FavoritesRepository extends JpaRepository<UserFavorites, Long>{

}
