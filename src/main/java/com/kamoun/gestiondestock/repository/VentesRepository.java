package com.kamoun.gestiondestock.repository;

import com.kamoun.gestiondestock.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentesRepository extends JpaRepository<Vente, Integer> {

    Optional<Vente> findVentesByCode(String code);
}