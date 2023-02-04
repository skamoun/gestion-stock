package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client extends AbstractEntity{
    @Column(name = "_nom")
    private String nom;
    @Column(name = "_prenom")
    private String prenom;
    @Column(name = "_email")
    private String mail;
    @Embedded
private Adresse adresse ;
    @Column(name = "_photo")
    private String photo;
    @Column(name = "_num_tel")
    private String numTel;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;

}
