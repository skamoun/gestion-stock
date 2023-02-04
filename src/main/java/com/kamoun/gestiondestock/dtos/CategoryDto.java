package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Article;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
@Builder
@Data
public class CategoryDto {

    private String code;

    private String designation;


    private Collection<ArticleDto> articles;
}
