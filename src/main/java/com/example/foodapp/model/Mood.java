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
@Table(name="Moods")
public class Mood {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long moodId;
	 @Column(name = "mood_name")
	 private String moodName;
	 
	 @OneToMany(mappedBy = "mood")
	 private List<UserPreferences> userPreferences;

	 @OneToMany(mappedBy = "mood")
	 private List<Dish> dishes;
	 
	 // Default Constructor
	 public Mood() {
		 
	 }
	 

	// Parameterized constructor
	public Mood(String moodName) {
		super();
		this.moodName = moodName;
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
	
	
	 

	 
}
