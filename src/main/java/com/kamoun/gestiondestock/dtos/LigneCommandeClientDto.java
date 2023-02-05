package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder

public class LigneCommandeClientDto {


    private ArticleDto article ;

    private CommandeClientDto commandeClient;

    private BigDecimal prixUnit;

    private BigDecimal quantite;
}
