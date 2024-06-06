package com.springboot.ecommerce.controller;

import com.springboot.ecommerce.dto.CategoryRequest;
import com.springboot.ecommerce.dto.CategoryResponse;
import com.springboot.ecommerce.model.Category;
import com.springboot.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/category")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories =  categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    
    @GetMapping("/api/public/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        Category category = categoryService.getCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/api/public/category")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category){
        Category cat = categoryService.addCategory(category);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @PutMapping("/api/public/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,
                               @RequestBody Category category){
        Category updated = categoryService.updateCategory(category,id);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/api/public/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        String response =  categoryService.deleteCategory(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
