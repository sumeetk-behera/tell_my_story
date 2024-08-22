package com.example.tell_my_story.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailDto {

	private int id;

	private String name;

	private String email;

	private String password;

	private int age;
}
