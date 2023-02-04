package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commande_client")
public class CommandeClient extends AbstractEntity{
    private static final String CLIENT_JOIN_COLUMN ="_id_client";
    private String code;

    private LocalDate dateCommande;
    @ManyToOne
    @JoinColumn(name = CLIENT_JOIN_COLUMN)
    private Client client;
@OneToMany(mappedBy = "commandClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
