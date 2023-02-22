package com.kamoun.gestiondestock.repository;

import com.kamoun.gestiondestock.model.CommandeClient;
import com.kamoun.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    Optional<CommandeFournisseur> findByCode(String code);

    List<CommandeClient> findAllByFournisseurId(Integer id);
}
