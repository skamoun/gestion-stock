package com.kamoun.gestiondestock.repository;

import com.kamoun.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findByCode(String codeArticle);

    List<Article> findAllByCategoryId(Integer idCategory);


}
