package com.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
