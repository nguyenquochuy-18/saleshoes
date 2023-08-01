package com.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.domain.Description;

public interface DescriptionRepository extends JpaRepository<Description, Long> {
}
