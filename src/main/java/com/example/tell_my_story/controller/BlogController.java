package com.example.tell_my_story.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tell_my_story.constant.Constant;
import com.example.tell_my_story.dto.BlogDto;
import com.example.tell_my_story.dto.ResponseDto;
import com.example.tell_my_story.service.BlogService;

import jakarta.validation.Valid;

@RestController
public class BlogController {

	@Autowired
	private BlogService blogService;

	@PostMapping("/addblog")
	public ResponseEntity<ResponseDto> addBlog(@RequestBody  @Valid BlogDto blogDto) {
		return ResponseEntity.ok(new ResponseDto(false, Constant.BLOG_ADDED, blogService.addBlog(blogDto)));
	}
}
