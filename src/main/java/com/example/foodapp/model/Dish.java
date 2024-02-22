package com.example.foodapp.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private Set<Recipes> recipes = new HashSet<>();
    
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private Set<UserFavorites> favorites = new HashSet<>();
    
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

	public void addRecipe(Recipes recipes1) {
		this.recipes.add(recipes1);
		recipes1.setDish(this);
	}
	
	public void addFavorite(UserFavorites favorites1) {
		this.favorites.add(favorites1);
		favorites1.setDish(this);
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

	public Set<Recipes> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipes> recipes) {
		this.recipes = recipes;
	}

	public Set<UserFavorites> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<UserFavorites> favorites) {
		this.favorites = favorites;
	}
    
}
