package com.springboot.ecommerce.controller;

import com.springboot.ecommerce.dto.CategoryRequest;
import com.springboot.ecommerce.dto.CategoryResponse;
import com.springboot.ecommerce.model.Category;
import com.springboot.ecommerce.service.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/category")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    
    @GetMapping("/api/public/category/{id}")
    public Category getCategory(@PathParam("") String id){
        //list.stream().
        return null;
    }

    @PostMapping("/api/public/category")
    public String addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    
    public void updateCategory(){}
    
    public void deleteCategory(){}
    
}
