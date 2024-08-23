package com.example.tell_my_story.service;

import java.util.List;

import com.example.tell_my_story.dto.StatusDto;

public interface StatusService {

	StatusDto addStatus(StatusDto statusDto);

	List<StatusDto> getStatus();

}
