package com.example.tell_my_story.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tell_my_story.constant.ExceptionConstant;
import com.example.tell_my_story.dto.CategoryDto;
import com.example.tell_my_story.entity.Category;
import com.example.tell_my_story.exception.CategoryFoundException;
import com.example.tell_my_story.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository repository;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Optional<Category> existingCategory = repository.findByName(categoryDto.getName());
		if (existingCategory.isEmpty()) {
			Category category = new Category();
			BeanUtils.copyProperties(categoryDto, category);
			Category savedCategory = repository.save(category);			
			categoryDto.setId(savedCategory.getId());
			return categoryDto;
		}
		throw new CategoryFoundException("A blog with the provided category name = "+categoryDto.getName()+" already exists.");
	}

	@Override
	public List<CategoryDto> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
