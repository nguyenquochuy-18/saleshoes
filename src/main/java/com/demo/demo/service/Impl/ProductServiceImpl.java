package com.demo.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.domain.Category;
import com.demo.demo.domain.Products;

import com.demo.demo.repository.CategoryRepository;
import com.demo.demo.repository.ProductRepository;
import com.demo.demo.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryRepository repos;

    // private ProductsDTO product;

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Products> showListProduct(int categoryId) {
        List<Category> list = repos.findAll();
        List<Products> products = list.get(categoryId).getProductsList();
        return products;
    }

    @Override
    public List<Products> getAllProducts() {
        List<Products> products = repository.findAll();
        return products;
    }
}
