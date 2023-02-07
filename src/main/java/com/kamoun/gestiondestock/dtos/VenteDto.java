package com.kamoun.gestiondestock.dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
@Data
@Builder

public class VenteDto {
    private Integer id ;

    private String code;

    private Instant dateVente;

    private String commentaire;

}
