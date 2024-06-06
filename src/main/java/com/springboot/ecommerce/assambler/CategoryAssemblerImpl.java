package com.springboot.ecommerce.assambler;

import com.springboot.ecommerce.dto.CategoryRequest;
import com.springboot.ecommerce.dto.CategoryResponse;
import com.springboot.ecommerce.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryAssemblerImpl implements CategoryAssembler{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Category assemble(CategoryRequest req) {
        return  modelMapper.map(req, Category.class);
    }

    @Override
    public Category assemble(CategoryRequest req, Category cat) {
        Category update = modelMapper.map(req, Category.class);
        update.setCategoryId(cat.getCategoryId());
        return update;
    }

    @Override
    public CategoryResponse assemble(Category category) {
        return modelMapper.map(category, CategoryResponse.class);
    }
}
