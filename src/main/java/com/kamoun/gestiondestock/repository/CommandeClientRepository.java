package com.kamoun.gestiondestock.repository;

import com.kamoun.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

    Optional<CommandeClient> findByCode(String code);

    List<CommandeClient> findAllByClientId(Integer id);
}
