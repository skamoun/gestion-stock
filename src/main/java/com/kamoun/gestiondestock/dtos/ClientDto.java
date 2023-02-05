package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Adresse;
import com.kamoun.gestiondestock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder

public class ClientDto {

    private String nom;

    private String prenom;

    private String mail;

    private AdresseDto adresse ;

    private String photo;

    private String numTel;

    private List<CommandeClientDto> commandeClients;

}
