package com.springboot.ecommerce.service;

import com.springboot.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();
    public Category getCategory(Long id);
    public String addCategory(Category category);
    public Category updateCategory(Category category, Long id);
    public String deleteCategory(Long id);
}
