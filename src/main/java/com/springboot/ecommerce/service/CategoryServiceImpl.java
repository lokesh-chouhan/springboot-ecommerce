package com.springboot.ecommerce.service;

import com.springboot.ecommerce.assambler.CategoryAssembler;
import com.springboot.ecommerce.assambler.CategoryAssemblerImpl;
import com.springboot.ecommerce.dto.CategoryRequest;
import com.springboot.ecommerce.dto.CategoryResponse;
import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Category;
import com.springboot.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryAssembler categoryAssembler;

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {

        List<Category> list = categoryRepository.findAll();

        List<CategoryResponse> resList = list.stream()
                .map(cat -> categoryAssembler.assemble(cat))
                .toList();

        return resList;
    }

    @Override
    public CategoryResponse getCategory(Long id) {
        if(!categoryRepository.existsById(id))
            throw new ResourceNotFoundException("Category", "CategoryId", id);
        Category cat =  categoryRepository.getById(id);
        return categoryAssembler.assemble(cat);
    }

    @Override
    public CategoryResponse addCategory(CategoryRequest req) {
        // adding duplicate need to handle
        Category cat = categoryAssembler.assemble(req);
        cat = categoryRepository.save(cat);
        return categoryAssembler.assemble(cat);
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest update, Long id) {
        if(!categoryRepository.existsById(id))
            throw new ResourceNotFoundException("Category", "CategoryId", id);
        Category cat = categoryRepository.getById(id);
        cat = categoryAssembler.assemble(update, cat);
        cat = categoryRepository.save(cat);
        return categoryAssembler.assemble(cat);
    }

    @Override
    public String deleteCategory(Long id) {
        if(categoryRepository.existsById(id))
            throw new ResourceNotFoundException("Category", "CategoryId", id);
        categoryRepository.deleteById(id);
        return "deleted successfully !!";


    }
}
