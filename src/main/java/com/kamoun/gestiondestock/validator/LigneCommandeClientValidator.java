package com.kamoun.gestiondestock.validator;

import com.kamoun.gestiondestock.dtos.LigneCommandeClientDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {


    public static List<String> validate(LigneCommandeClientDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le prix unitaire de la ligne de commande");
            errors.add("Veuillez renseigner la quantité de la ligne commande");
            errors.add("la commandeest obligatoire");
            errors.add("article est obligatoire");
            return errors;
        }

        if (dto.getPrixUnit() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la ligne de commande");
        }
        if (dto.getQuantite() == null || dto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
            errors.add("Veuillez renseigner la quantité de la ligne commande");
        }
        if (dto.getCommandeClient() == null || dto.getCommandeClient().getId() == null) {
            errors.add(" la commandeest obligatoire ");
        }
        if (dto.getArticle() == null || dto.getArticle().getId() == null) {
            errors.add("article est obligatoire ");
        }

        return errors;
    }
}


