package com.example.tell_my_story.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tell_my_story.dto.BlogDto;
import com.example.tell_my_story.entity.Blog;
import com.example.tell_my_story.entity.Category;
import com.example.tell_my_story.entity.Status;
import com.example.tell_my_story.repository.AccountDetailRepository;
import com.example.tell_my_story.repository.BlogRepository;
import com.example.tell_my_story.repository.CategoryRepository;
import com.example.tell_my_story.repository.StatusRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private AccountDetailRepository accountDetailRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public BlogDto addBlog(BlogDto blogDto) {
		Blog blog = new Blog();
		BeanUtils.copyProperties(blogDto, blog);
		Status status = statusRepository.findById(1).get();
		Category category = categoryRepository.findByName(blogDto.getCategoryName()).get();
		blog.setStatus(status);
		blog.setCategory(category);
		Blog newBlog = blogRepository.save(blog);
		BeanUtils.copyProperties(newBlog, blogDto);
		return null;
	}

}
