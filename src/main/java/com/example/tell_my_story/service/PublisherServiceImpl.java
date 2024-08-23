package com.example.tell_my_story.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tell_my_story.constant.ExceptionConstant;
import com.example.tell_my_story.dto.BlogDto;
import com.example.tell_my_story.entity.AccountDetail;
import com.example.tell_my_story.entity.Blog;
import com.example.tell_my_story.entity.Category;
import com.example.tell_my_story.entity.Status;
import com.example.tell_my_story.exception.DataNotFoundException;
import com.example.tell_my_story.repository.AccountDetailRepository;
import com.example.tell_my_story.repository.BlogRepository;
import com.example.tell_my_story.repository.CategoryRepository;
import com.example.tell_my_story.repository.StatusRepository;

@Service
public class PublisherServiceImpl implements PublisherService {
	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private AccountDetailRepository accountDetailRepository;

	private BlogDto convertToDto(Blog blog) {
		BlogDto blogDto = new BlogDto();
		BeanUtils.copyProperties(blog, blogDto);
		Optional<Category> optionalCategory = categoryRepository.findById(blog.getCategory().getId());
		blogDto.setCategoryName(optionalCategory.get().getName());
		Optional<Status> optionalStatus = statusRepository.findById(blog.getStatus().getId());
		blogDto.setStatusName(optionalStatus.get().getStatusName());
		Optional<AccountDetail> optionalAccountUser = accountDetailRepository.findById(blog.getUserAccount().getId());
		blogDto.setUserId(optionalAccountUser.get().getId());
		Optional<AccountDetail> optionalAccountPublisher = accountDetailRepository
				.findById(blog.getPublisherAccount().getId());
		blogDto.setPublisherId(optionalAccountPublisher.get().getId());
		return blogDto;
	}

	@Override
	public List<BlogDto> getByStatus(String status, int id) {

		List<Blog> allBlog = blogRepository.findAll();
		List<Blog> filteredBlog = allBlog.stream().filter((s) -> s.getStatus().getStatusName().equalsIgnoreCase(status)
				&& (s.getPublisherAccount().getId() == id)).collect(Collectors.toList());
		if (filteredBlog.isEmpty()) {
			throw new DataNotFoundException(" id "+id +" or "+ status +" status "+ExceptionConstant.DATA_NOT_FOUND);
		}
		return filteredBlog.stream().map(this::convertToDto).collect(Collectors.toList());
	}

}
