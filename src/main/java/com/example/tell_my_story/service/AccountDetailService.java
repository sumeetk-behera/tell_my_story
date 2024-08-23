package com.example.tell_my_story.service;

import com.example.tell_my_story.dto.AccountDetailDto;

import jakarta.validation.Valid;

public interface AccountDetailService {

	public AccountDetailDto addAccount(AccountDetailDto accountDetailDto);

	public AccountDetailDto updateAccountDetail(int id, @Valid AccountDetailDto accountDetailDto);
}
