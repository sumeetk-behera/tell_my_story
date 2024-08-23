package com.example.tell_my_story.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tell_my_story.constant.ExceptionConstant;
import com.example.tell_my_story.dto.CategoryDto;
import com.example.tell_my_story.entity.Category;
import com.example.tell_my_story.exception.CategoryFoundException;
import com.example.tell_my_story.exception.DataNotFoundException;
import com.example.tell_my_story.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Optional<Category> existingCategory = categoryRepository.findByName(categoryDto.getName());
		if (existingCategory.isEmpty()) {
			Category category = new Category();
			BeanUtils.copyProperties(categoryDto, category);
			Category savedCategory = categoryRepository.save(category);
			categoryDto.setId(savedCategory.getId());
			return categoryDto;
		}
		throw new CategoryFoundException(categoryDto.getName() + ExceptionConstant.CATEGORY_FOUND);
	}

	@Override
	public List<CategoryDto> getCategory() {

		List<Category> categoryList = categoryRepository.findAll();

		List<CategoryDto> categoryDtoList = new ArrayList<>();

		if (!categoryList.isEmpty()) {

			for (Category category : categoryList) {
				CategoryDto dto = new CategoryDto();
				BeanUtils.copyProperties(category, dto);
				categoryDtoList.add(dto);
			}
			return categoryDtoList;
		}
		throw new DataNotFoundException(ExceptionConstant.DATA_NOT_FOUND);
	}

}
