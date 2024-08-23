package com.example.tell_my_story.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryFoundException extends RuntimeException {

	
	public String message;
}
