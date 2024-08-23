package com.example.tell_my_story.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	@ExceptionHandler(CategoryFoundException.class)
	public ResponseEntity<ResponseDto> dataNotFound(CategoryFoundException e) {
		return new ResponseEntity<ResponseDto>(new ResponseDto(true, e.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException ex){
		Map<String,String> errorMap= new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
}
