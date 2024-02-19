package com.example.foodapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Preferences")
public class UserPreferences {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userPreferencesId;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "mood_id", nullable = false)
	private Mood mood;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cuisine_id", nullable = false)
	private Cuisine cuisine;

	
	// Default Constructor
	public UserPreferences() {
		
	}

	// Parameterized constructor
	
	public UserPreferences(Long userPreferencesId) {
		super();
	}

	// Getters and Setters methods
	
	public Long getUserPreferencesId() {
		return userPreferencesId;
	}
	public void setUserPreferencesId(Long userPreferencesId) {
		this.userPreferencesId = userPreferencesId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}
	
	
}
