package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.model.TypeMvtStock;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder

public class MvtStkDto {
    private String quantite;

    private LocalDate dateMvt;

    private ArticleDto article ;

    private TypeMvtStock typeMvtStock;
}
