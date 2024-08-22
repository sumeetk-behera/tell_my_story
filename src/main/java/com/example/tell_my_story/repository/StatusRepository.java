package com.example.tell_my_story.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tell_my_story.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
	
	Optional<Status> findByStatus(String status);

}
