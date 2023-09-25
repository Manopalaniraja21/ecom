package com.ecom.main.entity;

import jakarta.persistence.Entity;

@Entity
public class UserEntity {
	private Long userId;
	private String userName;
	private String userEmail;
	private String userPhone;

}
