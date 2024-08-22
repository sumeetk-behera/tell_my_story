package com.example.tell_my_story.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tell_my_story.entity.AccountDetail;


@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail, Integer> {

	Optional<AccountDetail> findByEmail(String email);
	
}
