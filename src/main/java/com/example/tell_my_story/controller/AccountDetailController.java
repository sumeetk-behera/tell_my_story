package com.example.tell_my_story.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tell_my_story.constant.Constant;
import com.example.tell_my_story.dto.AccountDetailDto;
import com.example.tell_my_story.dto.ResponseDto;
import com.example.tell_my_story.service.AccountDetailService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@OpenAPIDefinition(info = @Info(title = "TELL MY STORY APPLICATION"))
@Slf4j
public class AccountDetailController {

	@Autowired
	private AccountDetailService accountDetailService;

	@PostMapping("/saveAccount")
	public ResponseEntity<ResponseDto> addAccount(@Valid @RequestBody AccountDetailDto accountDetailDto) {
		log.info("Account controller called");
		return ResponseEntity
				.ok(new ResponseDto(false, Constant.ACCOUNT_ADDED, accountDetailService.addAccount(accountDetailDto)));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDto> updateAccountDetail(@PathVariable int id,
			@Valid @RequestBody AccountDetailDto accountDetailDto) {

		return ResponseEntity.ok(new ResponseDto(false, Constant.DATA_UPDATED,
				accountDetailService.updateAccountDetail(id, accountDetailDto)));
	}
	
}
