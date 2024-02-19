package com.example.foodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Dishes")
public class Dish {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dishId;
	
	@Column(name = "dishName")
    private String dishName;
	@Column(name = "description")
    private String description;
	@Column(name = "ingredients")
    private String ingredients;
	@Column(name = "imageURL")
    private String imageURL;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "mood_id", nullable = false)
    private Mood mood;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cuisine_id", nullable = false)
    private Cuisine cuisine;
    
    // Default Constructor
    public Dish() {
    	
    }

    // Parameterized constructor
	public Dish(String dishName, String description, String ingredients, String imageURL) {
		super();
		this.dishName = dishName;
		this.description = description;
		this.ingredients = ingredients;
		this.imageURL = imageURL;
	}

	// Getters and Setters methods
	public Long getDishId() {
		return dishId;
	}
	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}
    
}
