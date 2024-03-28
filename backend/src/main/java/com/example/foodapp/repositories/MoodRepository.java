package com.example.foodapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodapp.model.Mood;

public interface MoodRepository extends JpaRepository<Mood, Long>{
	
	List<Mood> findByMoodName(String moodName);

}
