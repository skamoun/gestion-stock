package com.kamoun.gestiondestock.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamoun.gestiondestock.model.Client;
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
    @JsonIgnore
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
