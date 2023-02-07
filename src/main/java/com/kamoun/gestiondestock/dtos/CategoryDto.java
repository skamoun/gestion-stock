package com.kamoun.gestiondestock.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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

    public CategoryDto  fromEntity(Category category){
        if(category==null){
            // TODO throw an exception
            return null;
        }
        return  CategoryDto.builder()
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
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
    return  category;
    }
}
