package com.kamoun.gestiondestock.validator;

import com.kamoun.gestiondestock.dtos.UtilisateurDto;
import lombok.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Validated
public class UtilsateurValidator {

    public static List<String> validate(@NonNull UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();
        if (!StringUtils.hasLength(utilisateurDto.getNom()))
            errors.add("veuillez renseigner le nom de  l'utilisateur ");
        if (!StringUtils.hasLength(utilisateurDto.getPrenom()))
            if (!StringUtils.hasLength(utilisateurDto.getMail()))
                errors.add("veuillez renseigner l'email de  l'utilisateur ");
        errors.add("veuillez renseigner le prenom de  l'utilisateur ");
        if (!StringUtils.hasLength(utilisateurDto.getPassword()))
            errors.add("veuillez renseigner le password de  l'utilisateur ");
        if (!StringUtils.hasLength(utilisateurDto.getNom()))
            errors.add("veuillez renseigner le nomde  l'utilisateur ");
        if (!StringUtils.hasLength(utilisateurDto.getDateNaissance()))
            errors.add("veuillez renseigner la date de naissance de  l'utilisateur ");
        if (utilisateurDto.getAdresse() == null)
            errors.add("veuillez renseigner l'adresse ");
        errors.addAll(AdresseValidator.validate(utilisateurDto.getAdresse()));


        return errors;
    }
}
