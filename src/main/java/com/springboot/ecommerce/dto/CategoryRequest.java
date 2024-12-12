package com.springboot.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private Long categoryId;

    @NotBlank(message = "Category name should not be blank...")
    private String categoryName;
}
