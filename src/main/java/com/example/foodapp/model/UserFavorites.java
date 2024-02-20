package com.example.foodapp.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Favorites")
public class UserFavorites {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long favoriteId;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	
	// Default Constructor
	
	public UserFavorites() {
		
	}

	// Parameterized constructor
	
	public UserFavorites(Long favoriteId, Date creationDate) {
		super();
	}
	
	// Getters and Setters
	
	@PrePersist
    protected void onCreate() {
        creationDate = new Date();
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

	public Long getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
	}

	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
