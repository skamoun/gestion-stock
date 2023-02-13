package com.kamoun.gestiondestock.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamoun.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
@Builder
@Data
public class CategoryDto {
    private Integer id ;


    private String code;

    private String designation;

@JsonIgnore
    private Collection<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            // TODO throw an exception
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public Category  toEntity(CategoryDto categoryDto){
        if(categoryDto==null){
            // TODO throw an exception
            return null;
        }
        Category category = new Category();
        category.setId(categoryDto.id);
        category.setCode(categoryDto.code);
        category.setDesignation(categoryDto.designation);
    return  category;
    }
}
