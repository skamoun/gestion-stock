package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {
   private Integer id;
    private String code;

    private String designation;

    private BigDecimal prixUnitHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitTtc;

    private String photo;
    private Integer idEntreprise;
    private CategoryDto category;


    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            // TODO throw an exception
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .code(article.getCode())
                .designation(article.getDesignation())
                .photo(article.getPhoto())
                .prixUnitHt(article.getPrixUnitHt())
                .prixUnitTtc(article.getPrixUnitTtc())
                .tauxTva(article.getTauxTva())
                .idEntreprise(article.getIdEntreprise())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            // TODO throw an exception
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCode(articleDto.getCode());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitHt(articleDto.getPrixUnitHt());
        article.setPrixUnitTtc(articleDto.getPrixUnitTtc());
        article.setPrixUnitHt(articleDto.getPrixUnitHt());
        article.setPhoto(articleDto.getPhoto());
        article.setTauxTva(articleDto.tauxTva);
        article.setIdEntreprise(articleDto.getIdEntreprise());

        return  article;
    }
}
