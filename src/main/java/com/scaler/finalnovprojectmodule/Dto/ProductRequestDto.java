package com.scaler.finalnovprojectmodule.Dto;

import com.scaler.finalnovprojectmodule.models.Category;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull (message = "Category is required")
    private Category category;

    @Positive(message = "Price must be greater than 0")
    private double price;

    //@NotBlank(message = "Image URL is required")
    private String imageUrl;


}