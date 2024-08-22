package com.example.tell_my_story.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AccountDetail {

	@Id
	private int id;
	private String name;
	private String email;
	private String password;
	private int age;

}
