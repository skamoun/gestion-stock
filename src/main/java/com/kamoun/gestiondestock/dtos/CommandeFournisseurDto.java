package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Fournisseur;
import com.kamoun.gestiondestock.model.LigneCommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@Builder

public class CommandeFournisseurDto {
    @Column(name = "_code")
    private String code;
    @Column(name = "_date_commande")
    private LocalDate dateCommande;

    private FournisseurDto fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;
}
