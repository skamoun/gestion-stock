package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Integer id);

    ArticleDto findByCode(String code);

    List<ArticleDto> findAll();

    void delete(Integer id);
}
