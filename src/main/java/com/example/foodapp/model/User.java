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
@Table(name="Users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
	@Column(name = "user_name")
    private String userName;
	@Column(name = "password")
    private String passWord;
    
    @OneToMany(mappedBy = "user")
    private List<UserPreferences> userPreferences;
    
    // Default constructor
    public User() {
    	
    }
    
    // Parameterized constructor
	public User(String username, String password) {
		super();
		this.userName = username;
		this.passWord = password;
	}

	// Getters and Setters methods
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return passWord;
	}
	public void setPassword(String password) {
		this.passWord = password;
	}
	
}
