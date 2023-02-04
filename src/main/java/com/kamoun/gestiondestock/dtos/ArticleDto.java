package com.kamoun.gestiondestock.dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private String code;

    private String designation;

    private BigDecimal prixUnitHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitTtc;

    private String photo;
    private String category;
}
