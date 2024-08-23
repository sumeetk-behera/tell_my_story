package com.example.tell_my_story.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tell_my_story.constant.ExceptionConstant;
import com.example.tell_my_story.dto.AccountDetailDto;
import com.example.tell_my_story.entity.AccountDetail;
import com.example.tell_my_story.entity.Role;
import com.example.tell_my_story.exception.DataFoundException;
import com.example.tell_my_story.exception.DataNotFoundException;
import com.example.tell_my_story.repository.AccountDetailRepository;
import com.example.tell_my_story.repository.RoleRepository;

@Service
public class AccountDetailServiceImpl implements AccountDetailService {

	@Autowired
	private AccountDetailRepository accountDetailRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public AccountDetailDto addAccount(AccountDetailDto accountDetailDto) {
		Optional<AccountDetail> accountByEmail = accountDetailRepository.findByEmail(accountDetailDto.getEmail());

		if (accountByEmail.isPresent())
			throw new DataFoundException(ExceptionConstant.DATA_FOUND);

		List<Role> all = roleRepository.findAll();
		System.out.println(all);
		
		Role role = roleRepository.findByRoleName(accountDetailDto.getRoleName()).orElseThrow(() -> new DataNotFoundException(ExceptionConstant.ROLE_NOT_FOUND));
		
		
		AccountDetail accountDetail = new AccountDetail();
		BeanUtils.copyProperties(accountDetailDto, accountDetail);
		accountDetail.setRole(role);
		
		AccountDetail newAccountDetail = accountDetailRepository.save(accountDetail);
		BeanUtils.copyProperties(newAccountDetail, accountDetailDto);
		return accountDetailDto;

	}

}
