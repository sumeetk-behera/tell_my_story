package com.example.tell_my_story.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tell_my_story.constant.Constant;
import com.example.tell_my_story.dto.ResponseDto;
import com.example.tell_my_story.dto.StatusDto;
import com.example.tell_my_story.service.StatusService;

@RestController
public class StatusController {
	@Autowired
	private StatusService statusService;

	@PostMapping("/addStatus")
	protected ResponseEntity<ResponseDto> addStatus(@RequestBody StatusDto statusDto) {
		StatusDto status = statusService.addStatus(statusDto);
		return ResponseEntity.ok(new ResponseDto(false, Constant.STATUS_ADDED, status));

	}

	@GetMapping("/getStatus")
	public ResponseEntity<ResponseDto> getStatus() {
		return ResponseEntity.ok(new ResponseDto(false, Constant.STATUS_ADDED, statusService.getStatus()));
	}
}
