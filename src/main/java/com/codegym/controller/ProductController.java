package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("Categories")
    private Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    @PostMapping("/create-product")
    public ModelAndView showCreateForm(){
        Iterable<Category> categories = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("category", categories());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView saveProduct(@ModelAttribute("product")Product product){
        iProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message","Hoàn thành tạo sản phẩm");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView listProducts(){
        Iterable<Product> products = iProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Product product = iProductService.findById(id);
        if (product != null){
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-product")
    public ModelAndView updateProduct(@ModelAttribute("product")Product product){
        iProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Cập nhật sản phẩm thành công");
        return modelAndView;
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Product product = iProductService.findById(id);
        if (product != null){
            ModelAndView modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product){
        iProductService.remote(product.getId());
        return "redirect:products";
    }

    @GetMapping("/view-product/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id){
        Category category = iCategoryService.findById(id);
        if (category == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Product> products = iProductService.findAllByCategory(category);
        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category", category);
        modelAndView.addObject("product", products);
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView listProducts(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Product> products;
        if (s.isPresent()){
            products = iProductService.findAllByNameContaining(s.get(), pageable);
        } else {
            products = iProductService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

}
