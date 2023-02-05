package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Roles  extends AbstractEntity{
    private static final String USER_JOIN_COLUMN = "_id_utilisateur";
    @Column(name = "_role_name")
    private String roleName;

@ManyToOne
@JoinColumn( name = USER_JOIN_COLUMN)
    private Utilisateur utilisateur;
}
