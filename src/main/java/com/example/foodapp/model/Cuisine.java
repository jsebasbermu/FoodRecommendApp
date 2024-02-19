package com.example.foodapp.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Cuisines")
public class Cuisine {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cuisineId;

	@Column(name = "cuisine_name")
    private String cuisineName;
    
    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<UserPreferences> userPreferences = new HashSet<>();

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Dish> dishes = new HashSet<>();
    
    // Default constructor
    public Cuisine() {
    	
    }

    // Parameterized constructor
	public Cuisine(String cuisineName) {
		super();
		this.cuisineName = cuisineName;
	}
	
	// Method to add a dish to the cuisine
	
	public void addDish(Dish dish) {
		this.dishes.add(dish);
		dish.setCuisine(this);
	}
	
	public void addUserPreference(UserPreferences preference) {
		this.userPreferences.add(preference);
		preference.setCuisine(this);
	}
	
	// Getters and Setters methods
	public Long getCuisineId() {
		return cuisineId;
	}
	public void setCuisineId(Long cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getCuisineName() {
		return cuisineName;
	}
	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	public Set<UserPreferences> getUserPreferences() {
		return userPreferences;
	}

	public void setUserPreferences(Set<UserPreferences> userPreferences) {
		this.userPreferences = userPreferences;
	}

	public Set<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}

    
}
