package com.example.foodapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.foodapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUserName(String userName);
}
