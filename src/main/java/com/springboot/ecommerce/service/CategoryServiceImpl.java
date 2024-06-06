package com.springboot.ecommerce.service;

import com.springboot.ecommerce.assambler.CategoryAssambler;
import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Category;
import com.springboot.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{


    private CategoryAssambler categoryAssambler;
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
        if(!categoryRepository.existsById(id))
            throw new ResourceNotFoundException("Category", "CategoryId", id);
        return categoryRepository.getById(id);
    }

    @Override
    public Category addCategory(Category category) {
        // adding duplicate need to handle
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category updated, Long id) {
        if(!categoryRepository.existsById(id))
            throw new ResourceNotFoundException("Category", "CategoryId", id);
        Category existing = categoryRepository.getById(id);
        categoryAssambler.assamble(existing, updated);
        return categoryRepository.save(existing);
    }

    @Override
    public String deleteCategory(Long id) {
        if(categoryRepository.existsById(id))
            throw new ResourceNotFoundException("Category", "CategoryId", id);
        categoryRepository.deleteById(id);
        return "deleted successfully !!";


    }
}
