package com.example.tell_my_story.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDto {

	private Integer id;

	@NotBlank(message = "Title must not be blank")
	private String title;

	@NotBlank(message = "Description must not be blank")
	private String description;

	@NotNull(message = "UserId must not be null")
	private Integer userId;

	@NotNull(message = "PublisherId must not be null")
	private Integer publisherId;

	@NotBlank(message = "Category should not be blank")
	private String categoryName;

	private String status;

}
