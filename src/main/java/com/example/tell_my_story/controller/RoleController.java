package com.example.tell_my_story.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.tell_my_story.constant.Constant;
import com.example.tell_my_story.dto.ResponseDto;
import com.example.tell_my_story.dto.RoleDto;
import com.example.tell_my_story.service.RoleService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/addRole")
	public ResponseEntity<ResponseDto> addRole(@RequestBody @Valid RoleDto roleDto) {
		return new ResponseEntity<ResponseDto>(new ResponseDto(false, Constant.ROLE_ADDED, roleService.addRole(roleDto)), HttpStatus.CREATED);
	}
	
}
