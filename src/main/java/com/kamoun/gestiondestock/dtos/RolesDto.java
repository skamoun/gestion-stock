package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Utilisateur;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {

    private String roleName;


    private UtilisateurDto utilisateur;
}
