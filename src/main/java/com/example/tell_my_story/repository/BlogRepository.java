package com.example.tell_my_story.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tell_my_story.entity.Blog;
import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
}
