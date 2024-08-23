package com.example.tell_my_story.service;

import java.util.List;

import com.example.tell_my_story.dto.CategoryDto;

public interface CategoryService {
	CategoryDto addCategory(CategoryDto categoryDto);

	List<CategoryDto> getCategory();
}
