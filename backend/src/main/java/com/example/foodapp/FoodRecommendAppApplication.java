package com.example.foodapp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
			ArrayList<Cuisine> cuisines = InitializeCuisine();
			cuisineRepository.saveAll(cuisines);
			
			// List of moods			
			ArrayList<Mood> moods = InitializeMood();
			moodRepository.saveAll(moods);
			
			// List of users
			ArrayList<User> users = InitializeUser();
			userRepository.saveAll(users);
			
			// List of dishes
			ArrayList<Dish> dishes = InitializeDish(moods, cuisines);
			dishRepository.saveAll(dishes);
			
			// List of User Preferences
			ArrayList<UserPreferences> preferences = new ArrayList<>();
			preferences.add(new UserPreferences()); // bibimbap
			preferences.add(new UserPreferences()); // greencurry
			preferences.add(new UserPreferences()); // pho
			preferences.add(new UserPreferences()); // sushi
			preferences.add(new UserPreferences()); // nasi goreng
			preferences.add(new UserPreferences()); // pork chop
			preferences.add(new UserPreferences()); // baklava
			
			
			Dish bibimbap = dishes.get(0);
			Dish greenCurry = dishes.get(10);
			Dish pho = dishes.get(16);
			Dish sushi = dishes.get(24);
			Dish nasiGoreng = dishes.get(32);
			Dish porkChop = dishes.get(42);
			Dish baklava = dishes.get(53);
			
			

			
			// Adding dish to a cuisine
			cuisines.get(0).addDish(bibimbap); // bibimbap
			cuisines.get(1).addDish(greenCurry); // greenCurry
			cuisines.get(2).addDish(pho); // pho
			cuisines.get(3).addDish(sushi); // sushi
			cuisines.get(4).addDish(nasiGoreng); // nasiGoreng
			cuisines.get(5).addDish(porkChop); // porkChop
			cuisines.get(6).addDish(baklava); // baklava
			
			// Adding dish to a mood
			
			moods.get(0).addDish(bibimbap);
			moods.get(7).addDish(greenCurry);
			moods.get(7).addDish(pho);
			moods.get(7).addDish(sushi);
			moods.get(6).addDish(nasiGoreng);
			moods.get(5).addDish(porkChop);
			moods.get(2).addDish(baklava);
//			moods.get(7).addDish(dishes.get(7));
			
			// Adding user preference to a cuisine
			
			cuisines.get(0).addUserPreference(preferences.get(0));
			cuisines.get(1).addUserPreference(preferences.get(1));
			cuisines.get(2).addUserPreference(preferences.get(2));
			cuisines.get(3).addUserPreference(preferences.get(3));
			cuisines.get(4).addUserPreference(preferences.get(4));
			cuisines.get(5).addUserPreference(preferences.get(5));
			cuisines.get(6).addUserPreference(preferences.get(6));
			
	
			
			// Adding user preference to a mood
			
			moods.get(0).addUserPreference(preferences.get(0));
			moods.get(2).addUserPreference(preferences.get(1));
			moods.get(3).addUserPreference(preferences.get(2));
			moods.get(4).addUserPreference(preferences.get(3));
			moods.get(1).addUserPreference(preferences.get(4));
			moods.get(2).addUserPreference(preferences.get(5));
			moods.get(3).addUserPreference(preferences.get(6));
			
			// Adding user preference to a dish
			dishes.get(0).addUserPreference(preferences.get(0));;
			dishes.get(10).addUserPreference(preferences.get(1));
			dishes.get(16).addUserPreference(preferences.get(2));
			dishes.get(24).addUserPreference(preferences.get(3));
			dishes.get(32).addUserPreference(preferences.get(4));
			dishes.get(42).addUserPreference(preferences.get(5));
			dishes.get(53).addUserPreference(preferences.get(6));
			
			// Adding dish to a user preference
			
			
			// Adding user preference to a user
			
			users.get(0).addUserPreference(preferences.get(0));
			users.get(1).addUserPreference(preferences.get(1));
			users.get(2).addUserPreference(preferences.get(2));
			users.get(2).addUserPreference(preferences.get(3));
			users.get(0).addUserPreference(preferences.get(4));
			users.get(1).addUserPreference(preferences.get(5));
			users.get(1).addUserPreference(preferences.get(6));
			

			

			preferencesRepository.saveAll(preferences);
		
			
			// List of recipes
			
			ArrayList<Recipes> recipes = new ArrayList<>();
			recipes.add(new Recipes("Cook rice.\r\n"
					+ "Prepare vegetables (carrots, spinach, mushrooms).\r\n"
					+ "Cook vegetables separately.\r\n"
					+ "Cook ground beef with soy sauce and garlic.\r\n"
					+ "Fry eggs.\r\n"
					+ "Assemble: rice, vegetables, beef, egg.\r\n"
					+ "Top with gochujang sauce.\r\n"
					+ "Mix, serve. Enjoy!"));
			recipes.add(new Recipes("Pad Thai instructions"));
			recipes.add(new Recipes("Pho instructions"));
			recipes.add(new Recipes("Sushi instructions"));
			recipes.add(new Recipes("Nasi Goreng instructions"));
			recipes.add(new Recipes("Chicken rice instructions"));
			recipes.add(new Recipes("Manti instructions"));
			
			// Adding a dish to each of the recipes
			
			dishes.get(0).addRecipe(recipes.get(0));
			dishes.get(8).addRecipe(recipes.get(1));
			dishes.get(16).addRecipe(recipes.get(2));
			dishes.get(24).addRecipe(recipes.get(3));
			dishes.get(32).addRecipe(recipes.get(4));
			dishes.get(40).addRecipe(recipes.get(5));
			dishes.get(48).addRecipe(recipes.get(6));

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
	
	public ArrayList<Mood> InitializeMood() {
		// List of moods			
		ArrayList<Mood> moods = new ArrayList<>();
		
		Mood stressedMood = new Mood("Stressed",
				"Feeling pressure or tension, " + "often due to challenging situations or demands.");
		moods.add(stressedMood);
		
		Mood angryMood = new Mood("Angry", "Experiencing strong displeasure or "
				+ "irritation, often in response to perceived injustice or frustration.");
		moods.add(angryMood);
		
		Mood sadMood = new Mood("Sad",
				"Feeling sorrow or unhappiness, typically " + "in response to loss or disappointment.");
		moods.add(sadMood);
		
		Mood boredMood = new Mood("Bored", "Experiencing a lack of interest or stimulation, "
				+ "leading to feelings of tedium or restlessness.");
		moods.add(boredMood);
		
		Mood hungryMood = new Mood("Hungry", "Feeling a simple physical " + "need for food due to an empty stomach");
		moods.add(hungryMood);
		
		Mood happyMood = new Mood("Happy",
				"Experiencing joy, contentment, or positive " + "feelings that bring a sense of well-being.");
		moods.add(happyMood);
		
		Mood celebrationMood = new Mood("Celebration", "Feeling a heightened sense of joy or happiness, "
				+ "often associated with special occasions or positive events.");
		moods.add(celebrationMood);
		
		Mood lovedMood = new Mood("Loved", "Experiencing a deep affection and connection with others, "
				+ "often associated with feelings of warmth and care.");
		moods.add(lovedMood);
		
		return moods;
	}
	
	public ArrayList<User> InitializeUser() {
		ArrayList<User> users = new ArrayList<>();
		
		User sebastian = new User("Sebastian", "seb123456");
		User russell = new User("Russell", "rus678_99");
		User burak = new User("Burak", "burak12974_");
		
		// Test adding users
		users.add(sebastian);
		users.add(russell);
		users.add(burak);
		return users;
	}
	
	public ArrayList<Cuisine> InitializeCuisine(){
		ArrayList<Cuisine> cuisines = new ArrayList<>();
		// Initialize
		Cuisine koreanCuisine = new Cuisine("Korean");
		Cuisine thaiCuisine = new Cuisine("Thai");
		Cuisine vietCuisine = new Cuisine("Vietnamese");
		Cuisine japaneseCuisine = new Cuisine("Japanese");			
		Cuisine indoCuisine = new Cuisine("Indonesian");
		Cuisine colombianCuisine = new Cuisine("Colombian");
		Cuisine turkishCuisine = new Cuisine("Turkish");
		
		cuisines.add(koreanCuisine);
		cuisines.add(thaiCuisine);
		cuisines.add(vietCuisine);
		cuisines.add(japaneseCuisine);
		cuisines.add(indoCuisine);
		cuisines.add(colombianCuisine);
		cuisines.add(turkishCuisine);
		return cuisines;
	}
	
	public ArrayList<Dish> InitializeDish(ArrayList<Mood> moods, ArrayList<Cuisine> cuisines){
		ArrayList<Dish> dishes = new ArrayList<>();
		Cuisine koreanCuisine = cuisines.get(0);
		Cuisine thaiCuisine = cuisines.get(1);
		Cuisine vietCuisine = cuisines.get(2);
		Cuisine japaneseCuisine = cuisines.get(3);	
		Cuisine indoCuisine = cuisines.get(4);
		Cuisine colombianCuisine = cuisines.get(5);
		Cuisine turkishCuisine = cuisines.get(6);
		Mood stressedMood = moods.get(0);
		Mood angryMood = moods.get(1);
		Mood sadMood = moods.get(2);
		Mood boredMood = moods.get(3);
		Mood hungryMood = moods.get(4);
		Mood happyMood = moods.get(5);			
		Mood celebrationMood = moods.get(6);
		Mood lovedMood = moods.get(7);
		dishes.add(new Dish("Bibimbap","Cook rice, prepare assorted toppings (vegetables, beef or tofu), assemble in a bowl with a fried egg on top","Cook rice, sauté vegetables, cook protein, fry an egg","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",koreanCuisine,stressedMood));
		dishes.add(new Dish("Kimchi Jjigae","Boil kimchi with tofu, pork, and vegetables in a spicy broth","Boil kimchi with tofu, pork, vegetables, and broth","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",koreanCuisine,angryMood));
		dishes.add(new Dish("Bulgogi","Marinate thinly sliced beef in a mixture of soy sauce, sugar, garlic, and sesame oil, then grill or stir-fry","Marinate beef, grill or stir-fry","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",koreanCuisine,happyMood));
		dishes.add(new Dish("Japchae","Stir-fry sweet potato noodles with vegetables, meat (optional), and a soy sauce-based seasoning","Stir-fry noodles, vegetables, meat, and sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",koreanCuisine,celebrationMood));
		dishes.add(new Dish("Sundubu Jjigae","Boil soft tofu with vegetables, meat or seafood, and a spicy broth","Boil tofu with vegetables, meat or seafood, and broth","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",koreanCuisine,boredMood));
		dishes.add(new Dish("Kimchi","Ferment napa cabbage and Korean radish with a mixture of salt, garlic, ginger, fish sauce, and chili powder","Ferment vegetables with salt and seasoning","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",koreanCuisine,hungryMood));
		dishes.add(new Dish("Dakgalbi","Marinate chicken with a spicy sauce, stir-fry with vegetables, and serve with rice cakes","Marinate chicken, stir-fry with vegetables and sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",koreanCuisine,sadMood));
		dishes.add(new Dish("Samgyeopsal","Grill pork belly slices and serve with lettuce leaves, garlic, and ssamjang (spicy paste)","Grill pork belly, serve with lettuce and ssamjang","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",koreanCuisine,lovedMood));
		dishes.add(new Dish("Pad Thai","Stir-fry rice noodles with tofu, eggs, and peanuts in a sweet and sour sauce","Stir-fry noodles, tofu, eggs, peanuts, sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",thaiCuisine,happyMood));
		dishes.add(new Dish("Tom Yum Goong","Simmer shrimp and vegetables in a hot and sour broth with lemongrass and lime leaves","Boil broth, add shrimp, vegetables, lemongrass, lime leaves","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",thaiCuisine,stressedMood));
		dishes.add(new Dish("Green Curry","Simmer chicken or vegetables in a spicy coconut milk-based curry with Thai basil","Cook chicken or vegetables in curry sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",thaiCuisine,lovedMood));
		dishes.add(new Dish("Som Tum","Toss shredded green papaya, tomatoes, and other ingredients in a tangy dressing","Mix papaya, tomatoes, dressing","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",thaiCuisine,angryMood));
		dishes.add(new Dish("Massaman Curry","Slow-cook beef in a rich, aromatic curry with coconut milk, potatoes, and peanuts","Cook beef, potatoes, peanuts in curry sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",thaiCuisine,celebrationMood));
		dishes.add(new Dish("Pad Kra Pao","Stir-fry minced meat with Thai basil and chili, served over rice with a fried egg","Stir-fry meat, basil, chili, serve over rice with egg","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",thaiCuisine,sadMood));
		dishes.add(new Dish("Gaeng Keow Wan","Simmer chicken or vegetables in a fragrant green curry with coconut milk and Thai eggplant","Cook chicken or vegetables in green curry sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",thaiCuisine,hungryMood));
		dishes.add(new Dish("Khao Pad","Stir-fry rice with vegetables, egg, and choice of protein in a savory sauce","Stir-fry rice, vegetables, egg, protein","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",thaiCuisine,boredMood));
		dishes.add(new Dish("Pho","Simmer beef, noodles, and herbs in a fragrant broth, served with various toppings","Boil broth, add beef, noodles, herbs, toppings","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",vietCuisine,lovedMood));
		dishes.add(new Dish("Banh Mi","Assemble baguette with various fillings such as pork, pate, pickled vegetables, and cilantro","Fill baguette with toppings","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",vietCuisine,happyMood));
		dishes.add(new Dish("Bun Thit Nuong","Grill marinated pork and serve over vermicelli noodles with lettuce, herbs, and nuoc cham","Grill pork, serve over noodles with vegetables and sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",vietCuisine,hungryMood));
		dishes.add(new Dish("Goi Cuon","Roll shrimp, pork, vermicelli noodles, and herbs in rice paper, served with dipping sauce","Roll ingredients in rice paper, serve with sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",vietCuisine,celebrationMood));
		dishes.add(new Dish("Com Tam","Serve broken rice with grilled meat, fried egg, and pickled vegetables, with fish sauce","Serve rice with meat, egg, vegetables, fish sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",vietCuisine,boredMood));
		dishes.add(new Dish("Banh Xeo","Make a crispy pancake with shrimp, pork, bean sprouts, and turmeric, served with lettuce","Make pancake with filling, serve with lettuce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",vietCuisine,sadMood));
		dishes.add(new Dish("Bo Kho","Simmer beef, vegetables, and spices in a rich broth, served with French bread","Simmer beef, vegetables, spices in broth, serve with bread","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",vietCuisine,stressedMood));
		dishes.add(new Dish("Ca Kho To","Braise fish in a clay pot with caramel sauce, garlic, and shallots, served with rice","Braise fish with sauce, garlic, shallots, serve with rice","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",vietCuisine,angryMood));
		dishes.add(new Dish("Sushi","Prepare sushi rice, top with various ingredients, roll in seaweed","Cook rice, prepare ingredients, assemble on seaweed, roll","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",japaneseCuisine,lovedMood));
		dishes.add(new Dish("Ramen","Boil noodles, prepare broth, add toppings such as meat and veggies","Boil noodles, prepare broth, add toppings","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",japaneseCuisine,hungryMood));
		dishes.add(new Dish("Tempura","Dip seafood or vegetables in tempura batter, deep-fry until crispy","Dip in batter, deep-fry","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",japaneseCuisine,happyMood));
		dishes.add(new Dish("Teriyaki Chicken","Marinate chicken in teriyaki sauce, grill or pan-fry until cooked","Marinate chicken, grill or pan-fry","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",japaneseCuisine,celebrationMood));
		dishes.add(new Dish("Okonomiyaki","Mix batter with cabbage and other ingredients, cook on a griddle","Mix batter, cook on griddle with cabbage and other ingredients","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",japaneseCuisine,angryMood));
		dishes.add(new Dish("Tonkatsu","Bread and fry pork cutlet until golden brown","Bread pork, fry until golden brown","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",japaneseCuisine,boredMood));
		dishes.add(new Dish("Yakitori","Skewer and grill chicken pieces, basting with tare sauce","Skewer chicken, grill, baste with sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",japaneseCuisine,stressedMood));
		dishes.add(new Dish("Udon","Boil udon noodles, prepare broth, add toppings","Boil noodles, prepare broth, add toppings","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",japaneseCuisine,sadMood));
		dishes.add(new Dish("Nasi Goreng","Stir-fry cooked rice with vegetables, meat, and seasonings","Stir-fry rice with vegetables, meat, seasonings","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",indoCuisine,celebrationMood));
		dishes.add(new Dish("Rendang","Slow-cook beef in coconut milk and spices until tender","Slow-cook beef in coconut milk and spices","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",indoCuisine,lovedMood));
		dishes.add(new Dish("Satay","Skewer and grill marinated meat, serve with peanut sauce","Skewer meat, grill, serve with sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",indoCuisine,hungryMood));
		dishes.add(new Dish("Gado-Gado","Toss mixed vegetables and tofu with peanut sauce dressing","Toss vegetables and tofu with dressing","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",indoCuisine,happyMood));
		dishes.add(new Dish("Soto Ayam","Simmer chicken and vermicelli noodles in a fragrant broth","Simmer chicken and noodles in broth","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",indoCuisine,stressedMood));
		dishes.add(new Dish("Nasi Padang","Serve steamed rice with various Indonesian dishes","Steam rice, prepare dishes, serve together","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",indoCuisine,sadMood));
		dishes.add(new Dish("Martabak","Fill thick pancake with sweet or savory fillings, fry or grill","Fill pancake, fry or grill","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",indoCuisine,angryMood));
		dishes.add(new Dish("Babi Guling","Roast suckling pig with Balinese spices and serve with rice","Roast pig with spices, serve with rice","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",indoCuisine,boredMood));
		dishes.add(new Dish("Chicken rice","Cook rice, sauté chicken with vegetables, combine","Cook rice, sauté chicken, vegetables, combine","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",colombianCuisine,boredMood));
		dishes.add(new Dish("Grilled beef","Marinate beef, grill until desired doneness","Marinate beef, grill","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",colombianCuisine,celebrationMood));
		dishes.add(new Dish("Pork Chop","Season pork chops, grill or pan-fry until cooked through","Season pork chops, grill or pan-fry","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",colombianCuisine,happyMood));
		dishes.add(new Dish("Empanadas","Prepare dough, fill with meat or other fillings, fry until golden brown","Prepare dough, fill, fry until golden brown","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",colombianCuisine,hungryMood));
		dishes.add(new Dish("Arepas","Mix cornmeal with water and salt, form into patties, fry or grill","Mix cornmeal, water, salt, form patties, fry or grill","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",colombianCuisine,lovedMood));
		dishes.add(new Dish("Chicken soup","Simmer chicken with vegetables and herbs in a flavorful broth","Simmer chicken, vegetables, herbs in broth","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",colombianCuisine,sadMood));
		dishes.add(new Dish("Beef stew","Slow-cook beef with vegetables and spices until tender","Slow-cook beef, vegetables, spices","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",colombianCuisine,stressedMood));
		dishes.add(new Dish("Hot chocolate","Heat milk with chocolate, sugar, and spices until hot and smooth","Heat milk, chocolate, sugar, spices until smooth","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",colombianCuisine,angryMood));
		dishes.add(new Dish("Manti","Fill dough with seasoned meat, fold, cook in boiling water","Fill dough, fold, cook in water","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",turkishCuisine,lovedMood));
		dishes.add(new Dish("Adana Kebap","Season ground meat with spices, shape onto skewers, grill","Season meat, shape onto skewers, grill","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",turkishCuisine,angryMood));
		dishes.add(new Dish("Lentil soup","Cook lentils with vegetables and spices until soft and flavorful","Cook lentils, vegetables, spices","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",turkishCuisine,boredMood));
		dishes.add(new Dish("Hünkârbeğendi","Cook eggplant until soft, mash, mix with béchamel sauce","Cook eggplant, mash, mix with béchamel sauce","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",turkishCuisine,celebrationMood));
		dishes.add(new Dish("Stuffed leaves","Fill grape leaves with rice and meat mixture, cook until tender","Fill leaves, cook until tender","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",turkishCuisine,happyMood));
		dishes.add(new Dish("Baklava","Layer filo pastry with nuts and honey syrup, bake until golden","Layer pastry, nuts, syrup, bake","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",turkishCuisine,sadMood));
		dishes.add(new Dish("Lahmacun","Spread dough with spiced meat mixture, bake until crispy","Spread dough, meat mixture, bake until crispy","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",turkishCuisine,stressedMood));
		dishes.add(new Dish("Tantuni","Sauté thinly sliced meat with vegetables and spices, serve in flatbread","Sauté meat, vegetables, spices, serve in flatbread","https://www.mapfoodservice.com/wp-content/uploads/2020/12/recipe-placeholder.jpg",turkishCuisine,hungryMood));
		
		return dishes;
	}
}
