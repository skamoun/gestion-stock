package com.kamoun.gestiondestock.validator;

import com.kamoun.gestiondestock.dtos.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilsateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();
        if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getNom()))
            errors.add("veuillez renseigner le nom de  l'utilisateur ");
        if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getPrenom()))
            errors.add("veuillez renseigner le prenom de  l'utilisateur ");
        if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getPassword()))
            errors.add("veuillez renseigner le password de  l'utilisateur ");
        if (utilisateurDto == null || !StringUtils.hasLength(utilisateurDto.getNom()))
            errors.add("veuillez renseigner le nomde  l'utilisateur ");
        if (utilisateurDto == null || utilisateurDto.getAdresse() == null)
            errors.add("veuillez renseigner l'adresse ");
        return errors;
    }
}
