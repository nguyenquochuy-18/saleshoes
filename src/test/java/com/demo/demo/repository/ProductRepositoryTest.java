package com.demo.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.demo.domain.Products;
import com.demo.demo.service.ProductService;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService productService;

    @Test
    public void testFindAll() {
        List<Products> list = productService.getAllProducts();
        for (Products products : list) {
            System.out.println(products.getName());
        }
    }

    @Test
    public void testFindOne() {
        Optional<Products> products = repository.findById(1L);
        products.ifPresent(item -> System.out.println(item.getDescription().getDetailDescription()));
        System.out.println(products.get());
    }
}