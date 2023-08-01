package com.demo.demo.service;

import java.util.List;

import com.demo.demo.domain.Products;

public interface ProductService {

    List<Products> showListProduct(int categoryId);

    List<Products> getAllProducts();
}
