package com.example.foodapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    
    @OneToMany(mappedBy = "cuisine")
    private List<UserPreferences> userPreferences;

    @OneToMany(mappedBy = "cuisine")
    private List<Dish> dishes;
    
    // Default constructor
    public Cuisine() {
    	
    }

    // Parameterized constructor
	public Cuisine(String cuisineName) {
		super();
		this.cuisineName = cuisineName;
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
    
	
    
}
