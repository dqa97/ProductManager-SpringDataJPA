package com.codegym.service.product;

import com.codegym.model.Category;
import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    void remote(Long id);

    void save(Product product);

    Iterable<Product> findAllByCategory(Category category);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
