package com.example.tell_my_story.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tell_my_story.constant.Constant;
import com.example.tell_my_story.dto.CategoryDto;
import com.example.tell_my_story.dto.ResponseDto;
import com.example.tell_my_story.service.CategoryService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(info  = @Info(title =  "Category add controller"))
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@PostMapping("/add")
	@Operation(summary = "Add Category")
	public ResponseEntity<ResponseDto> addCategory(CategoryDto categoryDto){
		return new ResponseEntity<ResponseDto>(new ResponseDto(false,Constant.CATEGORY_ADDED,service.addCategory(categoryDto)),HttpStatus.CREATED);
		}
	
	@GetMapping("getCategory")
	public ResponseEntity<ResponseDto> getCategory(){
		return new ResponseEntity<ResponseDto>(new ResponseDto(false,Constant.CATEGORY_ADDED,service.getCategory()),HttpStatus.FOUND);
		}
}
