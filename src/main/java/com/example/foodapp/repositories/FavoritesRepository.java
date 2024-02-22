package com.example.foodapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodapp.model.UserFavorites;

public interface FavoritesRepository extends JpaRepository<UserFavorites, Long>{
}
