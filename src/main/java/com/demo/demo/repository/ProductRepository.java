package com.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.domain.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
