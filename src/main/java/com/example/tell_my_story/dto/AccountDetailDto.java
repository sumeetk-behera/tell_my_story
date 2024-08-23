package com.example.tell_my_story.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailDto {

	private int id;

	@NotBlank(message = "Name Should Not be Blank")
	private String name;

	@Email(message = "Invalid Email")
	private String email;

	@NotBlank(message = "Password should not be blank")
	@Size(min = 8, message = "Password should contain 8 characters ")
	private String password;

	@NotNull(message = "age should not be null")
	private int age;

	@NotBlank
	private String roleName;
}
