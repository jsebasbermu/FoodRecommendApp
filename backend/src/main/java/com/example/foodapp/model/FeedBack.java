package com.example.foodapp.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@CrossOrigin(origins = "http://localhost:8081")
@Entity
@Table(name = "UserFeedBack")
public class FeedBack {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long feedbackId;


	@Column(name = "dish_name")
	private String dish;

	@Column(name = "UserId")
	private int userId;

	@Column(name = "feedback1")
	private int feedback1;

	@Column(name = "feedback2")
	private int feedback2;

	@Column(name = "feedback3")
	private int feedback3;

	@Column(name = "feedback4")
	private int feedback4;

	@Column(name = "commentBox")
	private String commentBox;

	public FeedBack() {

	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFeedback1() {
		return feedback1;
	}

	public void setFeedback1(int feedback1) {
		this.feedback1 = feedback1;
	}

	public int getFeedback2() {
		return feedback2;
	}

	public void setFeedback2(int feedback2) {
		this.feedback2 = feedback2;
	}

	public int getFeedback3() {
		return feedback3;
	}

	public void setFeedback3(int feedback3) {
		this.feedback3 = feedback3;
	}

	public int getFeedback4() {
		return feedback4;
	}

	public void setFeedback4(int feedback4) {
		this.feedback4 = feedback4;
	}

	public String getCommentBox() {
		return commentBox;
	}

	public void setCommentBox(String commentBox) {
		this.commentBox = commentBox;
	}

	
	

}
