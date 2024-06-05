package com.springboot.ecommerce.service;

import com.springboot.ecommerce.model.Category;
import com.springboot.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{


    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public String addCategory(Category category) {
        categoryRepository.save(category);
         return "Added successfully !! ";
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        categoryRepository.save(category);
        return null;
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "deleted !!";

    }
}
