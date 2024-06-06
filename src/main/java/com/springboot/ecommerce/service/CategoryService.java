package com.springboot.ecommerce.service;

import com.springboot.ecommerce.dto.CategoryRequest;
import com.springboot.ecommerce.dto.CategoryResponse;
import com.springboot.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {

    public List<CategoryResponse> getAllCategories();
    public CategoryResponse getCategory(Long id);
    public CategoryResponse addCategory(CategoryRequest category);
    public CategoryResponse updateCategory(CategoryRequest category, Long id);
    public String deleteCategory(Long id);
}
