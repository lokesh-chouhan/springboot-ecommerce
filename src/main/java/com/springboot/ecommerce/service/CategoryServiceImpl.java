package com.springboot.ecommerce.service;

import com.springboot.ecommerce.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{

    List<Category> list = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return list;
    }

    @Override
    public Category getCategory(Long id) {
        return null;
    }

    @Override
    public String addCategory(Category category) {
         list.add(category);
         return "Added successfully !! ";
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return null;
    }

    @Override
    public String deleteCategory(Long id) {
        return null;
    }
}
