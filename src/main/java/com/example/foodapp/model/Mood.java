package com.example.foodapp.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@Table(name="Moods")
public class Mood {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long moodId;
	 @Column(name = "mood_name")
	 private String moodName;
	 
	 @Column(name = "mood_description")
	 private String moodDescription;
	 
	 @OneToMany(mappedBy = "mood", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private Set<UserPreferences> userPreferences = new HashSet<>();

	 @OneToMany(mappedBy = "mood", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private Set<Dish> dishes = new HashSet<>();
	 
	 // Default Constructor
	 public Mood() {
		 
	 }
	 

	// Parameterized constructor
	public Mood(String moodName, String moodDescription) {
		super();
		this.moodName = moodName;
		this.moodDescription = moodDescription;
	}

	public void addDish(Dish dish) {
		this.dishes.add(dish);
		dish.setMood(this);
	}
	
	public void addUserPreference(UserPreferences preference) {
		this.userPreferences.add(preference);
		preference.setMood(this);
	}
	
	// Getter and Setter methods
	public Long getMoodId() {
		return moodId;
	}
	public void setMoodId(Long moodId) {
		this.moodId = moodId;
	}

	public String getMoodName() {
		return moodName;
	}
	public void setMoodName(String moodName) {
		this.moodName = moodName;
	}


	public String getMoodDescription() {
		return moodDescription;
	}


	public void setMoodDescription(String moodDescription) {
		this.moodDescription = moodDescription;
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
