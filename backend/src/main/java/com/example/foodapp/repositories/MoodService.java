package com.example.foodapp.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodapp.model.*;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MoodService {
	@Autowired
    private MoodRepository moodRepository;

    public Set<Dish> getDishesByMood(Long moodId) {
    	Optional<Mood> moodOptional = moodRepository.findById(moodId);

        return moodOptional.map(Mood::getDishes)
                .orElse(Collections.emptySet());
    }
}
