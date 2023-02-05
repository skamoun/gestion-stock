package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.model.CommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneCommandeFournisseurDto {
    private ArticleDto article ;

    private CommandeFournisseurDto commandeFournisseur;

    private BigDecimal prixUnit;

    private BigDecimal quantite;
}
