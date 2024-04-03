package com.example.foodapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodapp.model.FeedBack;

public interface FeedbackRepository extends JpaRepository<FeedBack,Long>{

}
