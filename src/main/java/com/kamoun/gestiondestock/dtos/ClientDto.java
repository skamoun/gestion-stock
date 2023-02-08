package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Adresse;
import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.model.Client;
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
    private Integer id ;


    private String nom;

    private String prenom;

    private String mail;

    private AdresseDto adresse ;

    private String photo;

    private String numTel;

    private List<CommandeClientDto> commandeClients;


    public ClientDto  fromEntity(Client client){
        if(client==null){
            // TODO throw an exception
            return null;
        }
        return  ClientDto.builder()
                .id(client.getId())
                .mail(client.getMail())
                .nom(client.getNom())
                .photo(client.getPhoto())
                .prenom(client.getMail())
                .numTel(client.getNumTel())
                .build();
    }

    public Client  toEntity(ClientDto clientDto){
        if(clientDto==null){
            // TODO throw an exception
            return null;
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhoto(clientDto.getPhoto());
        client.setNumTel(clientDto.getNumTel());
        client.setMail(clientDto.mail);

        return  client;
    }

}
