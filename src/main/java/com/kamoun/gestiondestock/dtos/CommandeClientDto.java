package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Client;
import com.kamoun.gestiondestock.model.LigneCommandeClient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@Builder

public class CommandeClientDto {
    private String code;

    private LocalDate dateCommande;

    private ClientDto client;

    private List<LigneCommandeClientDto> ligneCommandeClients;
}
