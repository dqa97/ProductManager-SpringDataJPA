package com.codegym.service.category;

import com.codegym.model.Category;

public interface ICategoryService {

    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remote(Long id);
}
