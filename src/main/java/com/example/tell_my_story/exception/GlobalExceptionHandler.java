package com.example.tell_my_story.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.tell_my_story.dto.ResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DataFoundException.class)
	public ResponseEntity<ResponseDto> dataFound(DataFoundException e) {
		return new ResponseEntity<ResponseDto>(new ResponseDto(true, e.getMessage(), null), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseDto> dataNotFound(DataNotFoundException e) {
		return new ResponseEntity<ResponseDto>(new ResponseDto(true, e.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
}
