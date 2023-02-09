package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Roles;
import com.kamoun.gestiondestock.model.Utilisateur;
import com.kamoun.gestiondestock.model.Vente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {
    private Integer id ;


    private String roleName;


    private UtilisateurDto utilisateur;

    public static RolesDto  fromEntity(Roles roles){
        if(roles==null){
            // TODO throw an exception
            return null;
        }
        return  RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())

                .build();
    }

    public static  Roles  toEntity(RolesDto rolesDto){
        if(rolesDto==null){
            // TODO throw an exception
            return null;
        }
        Roles roles = new Roles();
        roles.setId(rolesDto.id);
        roles.setRoleName(rolesDto.roleName);

        return  roles;
    }
}
