package com.springboot.ecommerce.assambler;

import com.springboot.ecommerce.dto.CategoryRequest;
import com.springboot.ecommerce.dto.CategoryResponse;
import com.springboot.ecommerce.model.Category;

public interface CategoryAssembler {

    // Create
    public Category assemble(CategoryRequest req);

    // Update
    public Category assemble(CategoryRequest req, Category cat);

    // Get and GetAll
    public CategoryResponse assemble(Category category);



}
