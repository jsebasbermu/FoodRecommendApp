package com.example.foodapp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodapp.model.Dish;
import com.example.foodapp.model.User;
import com.example.foodapp.model.UserFavorites;

import java.util.*;

@Service
public class FavoritesService {
	@Autowired
    private FavoritesRepository userFavoritesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DishRepository dishRepository;
    
    public void saveUserFavorite(Long userId, UserFavorites userFavorites2)  {
    	UserFavorites userFavorites = new UserFavorites();
    	// Retrieve user and dish instances
    	User user = userRepository.findById(userId).orElseThrow();
        Dish dish = dishRepository.findById(userFavorites.getDish().getDishId()).orElseThrow();

        
        userFavorites.setUser(user);
        userFavorites.setDish(dish);
        userFavorites.setCreationDate(new Date()); // Set the creation date

        userFavoritesRepository.save(userFavorites);    }
}
