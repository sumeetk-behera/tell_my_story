package com.example.tell_my_story.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

	private int id;
	
	@NotBlank(message="Category name should not be blank")
	private String name;
}

