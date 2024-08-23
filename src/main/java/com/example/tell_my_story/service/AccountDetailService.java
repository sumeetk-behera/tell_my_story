package com.example.tell_my_story.service;

import com.example.tell_my_story.dto.AccountDetailDto;

public interface AccountDetailService {

	public AccountDetailDto addAccount(AccountDetailDto accountDetailDto);

	public AccountDetailDto updateAccountDetail(int id,AccountDetailDto accountDetailDto);
}
