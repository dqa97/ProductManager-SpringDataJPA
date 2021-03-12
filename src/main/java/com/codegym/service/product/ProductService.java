package com.codegym.service.product;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findOne(id);
    }

    @Override
    public void remote(Long id) {
        iProductRepository.delete(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return iProductRepository.findAllByCategory(category);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(name, pageable);
    }
}
