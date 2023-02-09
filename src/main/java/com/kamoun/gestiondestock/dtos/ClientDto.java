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


    public static ClientDto  fromEntity(Client client){
        if(client==null){
            // TODO throw an exception
            return null;
        }
        return  ClientDto.builder()
                .id(client.getId())
                .mail(client.getMail())
                .nom(client.getNom())
                .photo(client.getPhoto())
                .prenom(client.getPrenom())
                .numTel(client.getNumTel())
                .build();
    }

    public static  Client  toEntity(ClientDto clientDto){
        if(clientDto==null){
            // TODO throw an exception
            return null;
        }
        Client client = new Client();
        client.setId(clientDto.id);
        client.setNom(clientDto.nom);
        client.setPrenom(clientDto.prenom);
        client.setPhoto(clientDto.photo);
        client.setNumTel(clientDto.numTel);
        client.setMail(clientDto.mail);

        return  client;
    }

}
