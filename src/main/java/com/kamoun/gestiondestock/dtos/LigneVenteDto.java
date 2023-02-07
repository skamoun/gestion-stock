package com.kamoun.gestiondestock.dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {
    private Integer id ;

    private VenteDto ventes;
    @Column(name = "_quantite")
    private BigDecimal quantite;
    @Column(name = "_prix_unit")
    private BigDecimal prixUnit;
}
