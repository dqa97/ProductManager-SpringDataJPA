package com.codegym.service.category;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService implements ICategoryService {

    @Autowired
    public ICategoryRepository iCategoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remote(Long id) {
        iCategoryRepository.delete(id);
    }
}
