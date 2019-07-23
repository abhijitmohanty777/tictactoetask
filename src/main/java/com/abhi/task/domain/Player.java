package com.abhi.task.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Player {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "user_name", unique = true, nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	public Player() {
		
	}

	public Player(String email, String userName, String password) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
}
