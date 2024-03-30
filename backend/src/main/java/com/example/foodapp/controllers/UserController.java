package com.example.foodapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.foodapp.model.User;
import com.example.foodapp.model.UserFavorites;
import com.example.foodapp.repositories.UserRepository;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String userName) {
		try {
//			List<User> users = new ArrayList<User>();
//
//			if (userName == null)
//				userRepository.findAll().forEach(users::add);
//			else //findBy
//				userRepository.findByUserName(userName).forEach(users::add);
//
//			if (users.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//
//			return new ResponseEntity<>(users, HttpStatus.OK);
			List<User> users = new ArrayList<>();

	        if (userName == null || userName.isEmpty()) {
	            userRepository.findAll().forEach(users::add);
	        } else {
	            // Use findByUserName to filter users by username
	            Optional<User> user = userRepository.findByUserName(userName);
	            user.ifPresent(users::add);
	        }

	        if (users.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }

	        return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
	    try {
	        Optional<User> userData = userRepository.findById(id);
	        if (userData.isPresent()) {
	            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping("/users")
    public ResponseEntity<String> createUserFavorite(@RequestBody User newUser) {
        try {
            // Save the new favorite
            userRepository.save(newUser);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
}
