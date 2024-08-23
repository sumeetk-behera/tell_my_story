package com.example.tell_my_story.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tell_my_story.constant.Constant;
import com.example.tell_my_story.dto.ResponseDto;
import com.example.tell_my_story.service.PublisherService;

@RestController
public class PublisherController {
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping("/getByStatus")
	public ResponseEntity<ResponseDto> getByStatus(@RequestParam String status,@RequestParam int id) {
		return ResponseEntity.ok(new ResponseDto(false,"Pending "+Constant.DATA_FETCHED,
				publisherService.getByStatus(status,id)));
	}
}
