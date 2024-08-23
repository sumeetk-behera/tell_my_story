package com.example.tell_my_story.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

	@JsonIgnore
	private int id;
	
	@NotBlank(message = "role name should not be blank")
	private String roleName;

}
