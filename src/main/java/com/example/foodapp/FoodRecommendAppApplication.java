package com.example.foodapp;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.foodapp.model.Cuisine;
import com.example.foodapp.model.Dish;
import com.example.foodapp.model.Mood;
import com.example.foodapp.model.User;
import com.example.foodapp.repositories.CuisineRepository;
import com.example.foodapp.repositories.DishRepository;
import com.example.foodapp.repositories.MoodRepository;
import com.example.foodapp.repositories.UserRepository;

@SpringBootApplication
public class FoodRecommendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodRecommendAppApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CuisineRepository cuisineRepository, MoodRepository moodRepository,
			UserRepository userRepository, DishRepository dishRepository) {
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
			moodRepository
					.save(new Mood("Hungry", "Feeling a simple physical " + "need for food due to an empty stomach"));
			moodRepository.save(new Mood("Happy",
					"Experiencing joy, contentment, or positive " + "feelings that bring a sense of well-being."));
			moodRepository.save(new Mood("Celebration", "Feeling a heightened sense of joy or happiness, "
					+ "often associated with special occasions or positive events."));
			moodRepository.save(new Mood("Loved", "Experiencing a deep affection and connection with others, "
					+ "often associated with feelings of warmth and care."));

			// Test adding users
			userRepository.save(new User("Sebastian Bermudez", "seb123456"));
			userRepository.save(new User("Russell", "rus678_99"));
			userRepository.save(new User("Burak", "burak12974_"));
			userRepository.save(new User("Valentina Alvarez", "Valen12345_"));
			// new comment test

			// Korean
			dishRepository.save(new Dish("Bibimbap", "Mixed rice topped with vegetables, meat, and a sauce",
					"Rice, vegetables (carrots, spinach, mushrooms), beef, gochujang (Korean red pepper paste)",
					"URL"));
			dishRepository.save(new Dish("Kimchi Jjigae", "Spicy kimchi stew with tofu and pork",
					"Kimchi, tofu, pork, garlic, onions, Korean chili flakes", "URL"));
			dishRepository.save(new Dish("Bulgogi", "Marinated and grilled beef",
					"Beef, soy sauce, sugar, sesame oil, garlic", "URL"));
			dishRepository.save(new Dish("Japchae", "Stir-fried glass noodles with vegetables and beef",
					"Sweet potato noodles, vegetables (spinach, carrots, mushrooms), beef, soy sauce", "URL"));
			dishRepository.save(new Dish("Sundubu Jjigae", "Soft tofu stew with vegetables and sometimes meat",
					"Soft tofu, vegetables (zucchini, mushrooms, onions), gochugaru (Korean red pepper flakes)",
					"URL"));

			// Thai
			dishRepository.save(
					new Dish("Pad Thai", "Stir-fried rice noodles with shrimp or chicken, tofu, peanuts, and lime",
							"Rice noodles, shrimp or chicken, tofu, peanuts, lime, bean sprouts", "URL"));
			dishRepository.save(new Dish("Tom Yum Goong", "Spicy and sour shrimp soup",
					"Shrimp, lemongrass, lime leaves, galangal, chili peppers ", "URL"));
			dishRepository.save(new Dish("Green Curry", "Thai green curry with meat and vegetables",
					"Green curry paste, coconut milk, meat (chicken, beef), eggplant, bamboo shoots", "URL"));
			dishRepository.save(new Dish("Som Tum", "Green papaya salad with chili, lime, and fish sauce",
					"Green papaya, tomatoes, chili peppers, lime, fish sauce, peanuts", "URL"));

			// Vietnamese
			dishRepository.save(new Dish("Pho", "Vietnamese noodle soup with broth, rice noodles, and meat",
					"Rice noodles, beef or chicken, broth (star anise, cinnamon, cloves), bean sprouts", "URL"));
			dishRepository.save(new Dish("Banh Mi", "Vietnamese baguette sandwich with various fillings",
					"Baguette, meat (usually pork or chicken), pickled vegetables, cilantro, mayonnaise", "URL"));
			dishRepository.save(new Dish("Bun Thit Nuong", "Grilled pork with vermicelli noodles and herbs",
					"Vermicelli noodles, grilled pork, lettuce, herbs, fish sauce", "URL"));
			dishRepository.save(new Dish("Goi Cuon", "Fresh spring rolls with shrimp, herbs, and vermicelli",
					"Rice paper, shrimp, vermicelli noodles, herbs, hoisin-peanut dipping sauce", "URL"));
			dishRepository.save(new Dish("Com Tam", "Broken rice with grilled meat and a side of fish sauce",
					"Broken rice, grilled meat (pork, chicken), pickled vegetables, fish sauce", "URL"));

			// Japanese
			dishRepository.save(new Dish("Sushi", "Vinegared rice combined with various ingredients, often seafood",
					"Sushi rice, seafood (fish, shrimp), nori (seaweed), soy sauce, wasabi", "URL"));
			dishRepository.save(new Dish("Ramen", "Japanese noodle soup with Chinese-style wheat noodles",
					"Ramen noodles, broth (soy sauce or miso), meat (pork, chicken), green onions, nori ", "URL"));
			dishRepository.save(new Dish("Tempura", "Lightly battered and deep-fried seafood and vegetables",
					"Seafood (shrimp, fish) or vegetables (sweet potato, zucchini), tempura batter", "URL"));
			dishRepository.save(new Dish("Teriyaki Chicken", "Grilled chicken with a glossy, sweet soy-based glaze",
					"Chicken, soy sauce, mirin, sugar, sake", "URL"));
			dishRepository
					.save(new Dish("Okonomiyaki", "Savory pancake with various ingredients, often cabbage and meat",
							"Flour, cabbage, meat (pork or seafood), eggs, okonomiyaki sauce", "URL"));

			// Indonesian
			dishRepository.save(new Dish("Nasi Goreng",
					"Indonesian fried rice with a combination of meat, vegetables, and kecap manis ",
					"Cooked rice, meat (chicken, shrimp), kecap manis (sweet soy sauce), vegetables, fried shallots",
					"URL"));
			dishRepository.save(new Dish("Rendang", "Spicy slow-cooked meat dish, often beef",
					"Beef, coconut milk, lemongrass, galangal, turmeric, chili peppers", "URL"));
			dishRepository.save(new Dish("Satay", "Skewered and grilled meat served with a peanut sauce",
					"Meat (chicken, beef), soy sauce, kecap manis, peanuts, chili, lemongrass", "URL"));
			dishRepository.save(new Dish("Gado-Gado", "Mixed vegetable salad with peanut sauce ",
					"Vegetables (potatoes, beans, spinach), peanut sauce, tofu, boiled eggs", "URL"));
			dishRepository.save(new Dish("Soto Ayam", "Chicken noodle soup with turmeric-based broth",
					"Chicken, rice noodles, turmeric, lemongrass, lime leaves", "URL"));

			// Colombian
			dishRepository.save(new Dish("Chicken rice ",
					"Shredded chicken breast with yellow rice and vegetables served in a big or small plate",
					"Chicken breast, rice with seasoning, vegetables, salad and fries. ", "URL"));
			dishRepository.save(new Dish("Grilled beef",
					"Grilled beef with rice, plantain and beans, it may be accompanied with sauce ",
					"Grilled beef, white rice, plantain, black or red beans, sauce, salad ", "URL"));
			dishRepository.save(new Dish("Pork Chop", "Breaded pork chop with rice and french fries ",
					"Pork chopped with rice, french fries, tomato sauce and salad ", "URL"));
			dishRepository.save(new Dish("Empanadas", "Baked or fried turnover consisting of pastry and filling",
					"Precooked corn flour filled with meat, potatoes, vegetables and spices", "URL"));
			dishRepository.save(new Dish("Arepas", "Corn cakes or corn bread made with ground maize dough",
					"Precooked white cornmeal flour, water, and salt, sometimes cheese on the inside ", "URL"));
			dishRepository.save(new Dish("Chicken soup",
					"A rich and hearty mix of tender chicken thighs, vegetables, and a light but flavorful herb-infused gravy",
					"Chicken, flour, vegetables, herbs, broth ", "URL"));
			dishRepository.save(new Dish("Beef stew ",
					"Also known as \"Sudado de carne de res\" is a stew made with beef or meatballs simmered in a flavorful broth with potatoes",
					"Beef, chicken or seafood, potatoes, yuca, spices, fresh herbs and vegetables like bell pepper, carrots, garlic and onions. ",
					"URL"));
			dishRepository.save(new Dish("Hot chocolate ",
					"Hot chocolate beverage which usually includes cheese melted to give an extra thick and creamy sensation ",
					"Milk, dark chocolate bars, sugar or honey and cheese ", "URL"));

			// Turkish
			dishRepository.save(new Dish("Manti",
					"It is a dish made by placing minced meat seasoned with various spices into small pieces of dough and boiling these pieces of dough in water.",
					"roasted minced meat, chickpea puree, black pepper, salt.", "URL"));
			dishRepository.save(new Dish("Adana Kebap",
					"A type of kebab or shish meatball in Turkish cuisine, unique to Adana, made from hand-chopped pieces of meat with a cleaver-like knife called \"zırh\".",
					"Lamb meat, lamb tail fat, chili pepper and salt", "URL"));
			dishRepository.save(new Dish("Lentil soup",
					"Lentil soup, whose main ingredient is red, yellow or green lentils; Soup prepared with flour, salt, butter, broth, onion, red or black pepper.",
					"lentils, onion, carrot, potato, salt, black pepper", "URL"));
			dishRepository.save(new Dish("Hünkârbeğendi",
					"Hünkârbeğendi, or simply liked it, is a dish belonging to the Ottoman cuisine. It's made with smoked and spiced eggplant, grilled, then pureed and mixed with milk, melted butter and toasted flour. It is served by placing lamb meat on top of the mixture.",
					"roasted eggplant, lamb, milk, flour", "URL"));
			dishRepository.save(new Dish("Stuffed leaves",
					"It is a dish made by putting bulgur or rice inside vine leaves and other filling ingredients that vary depending on the region. The ingredients are mixed and blended. It is then wrapped in pickled vine leaves.",
					"vine leaves, olive oil, onion, rice, peanuts, currants", "URL"));
			dishRepository.save(new Dish("Baklava",
					"It is an important dumpling that has a place in Turkish, Middle Eastern. It is made by placing walnuts, pistachios, almonds or hazelnuts, depending on the region, between thin sheets of dough. It is generally sweetened with sugar sherbet.",
					"wheat flour, clarified butter, pistachio kernels, beet sugar, water, wheat starch, egg, salt.",
					"URL"));
			dishRepository.save(new Dish("Lahmacun",
					"Lahmacun is a type of stuffed pita in Middle Eastern cuisine, made by spreading ingredients prepared with spices such as minced meat, parsley, onion, garlic, black pepper and isot (red pepper) on the rolled out dough and then baking it in a stone oven.",
					"minced meat, parsley, onion, garlic, black pepper and isot (red pepper)", "URL"));
			dishRepository.save(new Dish("Tantuni",
					"Cut small pieces of meat into tomatoes, peppers, onions, etc. A type of kebab made by cooking on hair.",
					"tail fat, oil, onion, allspice, cumin, chili pepper, black pepper, salt and parsley", "URL"));
		};

	}
}
