package com.example.tell_my_story.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tell_my_story.constant.ExceptionConstant;
import com.example.tell_my_story.dto.RoleDto;
import com.example.tell_my_story.entity.Role;
import com.example.tell_my_story.exception.DataFoundException;
import com.example.tell_my_story.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleDto addRole(RoleDto roleDto) {
		Optional<Role> optional = roleRepository.findByRoleName(roleDto.getRoleName());
		if (optional.isEmpty()) {
			Role role=new Role();
			BeanUtils.copyProperties(roleDto, role);
			Role newRole = roleRepository.save(role);
			BeanUtils.copyProperties(newRole, roleDto);
			return roleDto;
			}
		throw new DataFoundException(ExceptionConstant.DATA_FOUND);
	}
	
}
