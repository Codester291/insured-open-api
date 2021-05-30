package com.example.insuredopenapi.repository;


import com.example.insuredopenapi.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
