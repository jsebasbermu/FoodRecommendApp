package com.example.foodapp;

import java.util.ArrayList;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.foodapp.model.Cuisine;
import com.example.foodapp.model.Dish;
import com.example.foodapp.model.Mood;
import com.example.foodapp.model.Recipes;
import com.example.foodapp.model.User;
import com.example.foodapp.model.UserFavorites;
import com.example.foodapp.model.UserPreferences;
import com.example.foodapp.repositories.CuisineRepository;
import com.example.foodapp.repositories.DishRepository;
import com.example.foodapp.repositories.FavoritesRepository;
import com.example.foodapp.repositories.MoodRepository;
import com.example.foodapp.repositories.RecipesRepository;
import com.example.foodapp.repositories.UserPreferencesRepository;
import com.example.foodapp.repositories.UserRepository;

@SpringBootApplication
public class FoodRecommendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodRecommendAppApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CuisineRepository cuisineRepository, MoodRepository moodRepository,
			UserRepository userRepository, DishRepository dishRepository, 
			UserPreferencesRepository preferencesRepository, RecipesRepository recipesRepository,
			FavoritesRepository favoritesRepository) {
		return args -> {
			
			// List of cuisines
			ArrayList<Cuisine> cuisines = new ArrayList<>();
			cuisines.add(new Cuisine("Korean"));
			cuisines.add(new Cuisine("Thai"));
			cuisines.add(new Cuisine("Vietnamese"));
			cuisines.add(new Cuisine("Japanese"));
			cuisines.add(new Cuisine("Indonesian"));
			cuisines.add(new Cuisine("Colombian"));
			cuisines.add(new Cuisine("Turkish"));
			cuisineRepository.saveAll(cuisines);
			
			// List of moods
			
			ArrayList<Mood> moods = new ArrayList<>();
			
			moods.add(new Mood("Stressed",
					"Feeling pressure or tension, " + "often due to challenging situations or demands."));
			moods.add(new Mood("Angry", "Experiencing strong displeasure or "
					+ "irritation, often in response to perceived injustice or frustration."));
			moods.add(new Mood("Sad",
					"Feeling sorrow or unhappiness, typically " + "in response to loss or disappointment."));
			moods.add(new Mood("Bored", "Experiencing a lack of interest or stimulation, "
					+ "leading to feelings of tedium or restlessness."));
			moods.add(new Mood("Hungry", "Feeling a simple physical " + "need for food due to an empty stomach"));
			moods.add(new Mood("Happy",
					"Experiencing joy, contentment, or positive " + "feelings that bring a sense of well-being."));
			moods.add(new Mood("Celebration", "Feeling a heightened sense of joy or happiness, "
					+ "often associated with special occasions or positive events."));
			moods.add(new Mood("Loved", "Experiencing a deep affection and connection with others, "
					+ "often associated with feelings of warmth and care."));
			
			moodRepository.saveAll(moods);
			// List of users
			ArrayList<User> users = new ArrayList<>();
			// Test adding users
			users.add(new User("Sebastian Bermudez", "seb123456"));
			users.add(new User("Russell", "rus678_99"));
			users.add(new User("Burak", "burak12974_"));
			userRepository.saveAll(users);

			// List of dishes
			ArrayList<Dish> dishes = new ArrayList<>();

			// Korean
			dishes.add(new Dish("Bibimbap", "Mixed rice topped with vegetables, meat, and a sauce",
					"Rice, vegetables (carrots, spinach, mushrooms), beef, gochujang (Korean red pepper paste)",
					"URL"));
			// Thai
			dishes.add(
					new Dish("Pad Thai", "Stir-fried rice noodles with shrimp or chicken, tofu, peanuts, and lime",
							"Rice noodles, shrimp or chicken, tofu, peanuts, lime, bean sprouts", "URL"));
			// Vietnamese
			dishes.add(new Dish("Pho", "Vietnamese noodle soup with broth, rice noodles, and meat",
					"Rice noodles, beef or chicken, broth (star anise, cinnamon, cloves), bean sprouts", "URL"));
			// Japanese
			dishes.add(new Dish("Sushi", "Vinegared rice combined with various ingredients, often seafood",
					"Sushi rice, seafood (fish, shrimp), nori (seaweed), soy sauce, wasabi", "URL"));

			// Indonesian
			dishes.add(new Dish("Nasi Goreng",
					"Indonesian fried rice with a combination of meat, vegetables, and kecap manis ",
					"Cooked rice, meat (chicken, shrimp), kecap manis (sweet soy sauce), vegetables, fried shallots",
					"URL"));
			// Colombian
			dishes.add(new Dish("Chicken rice ",
					"Shredded chicken breast with yellow rice and vegetables served in a big or small plate",
					"Chicken breast, rice with seasoning, vegetables, salad and fries. ", "URL"));

			// Turkish
			dishes.add(new Dish("Manti",
					"It is a dish made by placing minced meat seasoned with various spices into small pieces of dough and boiling these pieces of dough in water.",
					"roasted minced meat, chickpea puree, black pepper, salt.", "URL"));
			
			// List of User Preferences
			ArrayList<UserPreferences> preferences = new ArrayList<>();
			preferences.add(new UserPreferences());
			preferences.add(new UserPreferences());
			preferences.add(new UserPreferences());
			preferences.add(new UserPreferences());
			preferences.add(new UserPreferences());
			preferences.add(new UserPreferences());
			preferences.add(new UserPreferences());

			
			// Adding a cuisine to the dishes
			
			cuisines.get(0).addDish(dishes.get(0));
			cuisines.get(1).addDish(dishes.get(1));
			cuisines.get(2).addDish(dishes.get(2));
			cuisines.get(3).addDish(dishes.get(3));
			cuisines.get(4).addDish(dishes.get(4));
			cuisines.get(5).addDish(dishes.get(5));
			cuisines.get(6).addDish(dishes.get(6));
			
			// Adding a cuisine to each of the user preferences
			
			cuisines.get(0).addUserPreference(preferences.get(0));
			cuisines.get(1).addUserPreference(preferences.get(1));
			cuisines.get(2).addUserPreference(preferences.get(2));
			cuisines.get(3).addUserPreference(preferences.get(3));
			cuisines.get(4).addUserPreference(preferences.get(4));
			cuisines.get(5).addUserPreference(preferences.get(5));
			cuisines.get(6).addUserPreference(preferences.get(6));
			
			// Adding a mood to each of the dishes
			
			moods.get(0).addDish(dishes.get(0));
			moods.get(1).addDish(dishes.get(1));
			moods.get(2).addDish(dishes.get(2));
			moods.get(3).addDish(dishes.get(3));
			moods.get(4).addDish(dishes.get(4));
			moods.get(5).addDish(dishes.get(5));
			moods.get(6).addDish(dishes.get(6));
			moods.get(7).addDish(dishes.get(6));
			
			// Adding a mood to each of the user preferences
			
			moods.get(0).addUserPreference(preferences.get(0));
			moods.get(2).addUserPreference(preferences.get(1));
			moods.get(3).addUserPreference(preferences.get(2));
			moods.get(4).addUserPreference(preferences.get(3));
			moods.get(1).addUserPreference(preferences.get(4));
			moods.get(2).addUserPreference(preferences.get(5));
			moods.get(3).addUserPreference(preferences.get(6));
			
			// Adding a user to each of the user preferences
			
			users.get(0).addUserPreference(preferences.get(0));
			users.get(1).addUserPreference(preferences.get(1));
			users.get(2).addUserPreference(preferences.get(2));
			users.get(2).addUserPreference(preferences.get(3));
			users.get(0).addUserPreference(preferences.get(4));
			users.get(1).addUserPreference(preferences.get(5));
			users.get(1).addUserPreference(preferences.get(6));

			preferencesRepository.saveAll(preferences);
			dishRepository.saveAll(dishes);
			
			// List of recipes
			
			ArrayList<Recipes> recipes = new ArrayList<>();
			recipes.add(new Recipes("Bibibamp instructions"));
			recipes.add(new Recipes("Pad Thai instructions"));
			recipes.add(new Recipes("Pho instructions"));
			recipes.add(new Recipes("Sushi instructions"));
			recipes.add(new Recipes("Nasi Goreng instructions"));
			recipes.add(new Recipes("Chicken rice instructions"));
			recipes.add(new Recipes("Manti instructions"));
			
			// Adding a dish to each of the recipes
			
			dishes.get(0).addRecipe(recipes.get(0));
			dishes.get(1).addRecipe(recipes.get(1));
			dishes.get(2).addRecipe(recipes.get(2));
			dishes.get(3).addRecipe(recipes.get(3));
			dishes.get(4).addRecipe(recipes.get(4));
			dishes.get(5).addRecipe(recipes.get(5));
			dishes.get(6).addRecipe(recipes.get(6));

			recipesRepository.saveAll(recipes);
			
			
			// List of user favorites record
			
			ArrayList<UserFavorites> favorites = new ArrayList<>();
			
			favorites.add(new UserFavorites());
			favorites.add(new UserFavorites());
			favorites.add(new UserFavorites());
			favorites.add(new UserFavorites());
			favorites.add(new UserFavorites());
			favorites.add(new UserFavorites());
			favorites.add(new UserFavorites());
			favorites.add(new UserFavorites());
			
			// Adding an user to user favorites record
			
			users.get(0).addFavorite(favorites.get(0));
			users.get(1).addFavorite(favorites.get(1));
			users.get(2).addFavorite(favorites.get(2));
			users.get(2).addFavorite(favorites.get(3));
			users.get(0).addFavorite(favorites.get(4));
			users.get(1).addFavorite(favorites.get(5));
			users.get(1).addFavorite(favorites.get(6));
			users.get(1).addFavorite(favorites.get(7));
			
			// Adding a dish to each user favorite record
			
			dishes.get(0).addFavorite(favorites.get(0));
			dishes.get(1).addFavorite(favorites.get(1));
			dishes.get(2).addFavorite(favorites.get(2));
			dishes.get(2).addFavorite(favorites.get(3));
			dishes.get(3).addFavorite(favorites.get(4));
			dishes.get(4).addFavorite(favorites.get(5));
			dishes.get(5).addFavorite(favorites.get(6));
			dishes.get(6).addFavorite(favorites.get(7));
			
			favoritesRepository.saveAll(favorites);
			
		};

	}
}
