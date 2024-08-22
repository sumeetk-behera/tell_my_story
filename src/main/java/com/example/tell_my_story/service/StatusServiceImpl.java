package com.example.tell_my_story.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tell_my_story.constant.ExceptionConstant;
import com.example.tell_my_story.dto.StatusDto;
import com.example.tell_my_story.entity.Status;
import com.example.tell_my_story.exception.StatusDataFoundException;
import com.example.tell_my_story.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public StatusDto addStatus(StatusDto statusDto) {
		Optional<Status> byStatus = statusRepository.findByStatus(statusDto.getStatus());

		if (byStatus.isEmpty()) {
			Status status = new Status();
			BeanUtils.copyProperties(statusDto, status);
			Status savedStatus = statusRepository.save(status);
			BeanUtils.copyProperties(savedStatus, statusDto);
			return statusDto;

		} else {
			throw new StatusDataFoundException(ExceptionConstant.DATA_FOUND);
		}
	}

}
