package com.example.tell_my_story.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusDto {

	private int id;

	@NotBlank(message = "Status should not be blank")
	private String statusName;
}
