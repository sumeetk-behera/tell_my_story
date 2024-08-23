package com.example.tell_my_story.service;

import java.util.List;

import com.example.tell_my_story.dto.BlogDto;

public interface PublisherService {

	List<BlogDto> getByStatus(String status, int id);

}
