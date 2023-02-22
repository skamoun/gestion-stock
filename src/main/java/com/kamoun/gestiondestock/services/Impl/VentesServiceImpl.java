package com.kamoun.gestiondestock.services.Impl;

import com.kamoun.gestiondestock.dtos.LigneVenteDto;
import com.kamoun.gestiondestock.dtos.VenteDto;
import com.kamoun.gestiondestock.exception.EntityNotFoundException;
import com.kamoun.gestiondestock.exception.ErrorCodes;
import com.kamoun.gestiondestock.exception.InvalidEntityException;
import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.model.LigneVente;
import com.kamoun.gestiondestock.model.Vente;
import com.kamoun.gestiondestock.repository.ArticleRepository;
import com.kamoun.gestiondestock.repository.LigneVenteRepository;
import com.kamoun.gestiondestock.repository.VentesRepository;
import com.kamoun.gestiondestock.services.VentesService;
import com.kamoun.gestiondestock.validator.VentesValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class VentesServiceImpl implements VentesService {
    private final VentesRepository ventesRepository;
    private final ArticleRepository articleRepository;
    private final LigneVenteRepository ligneVenteRepository;

    @Override
    public VenteDto save(VenteDto dto) {
        List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes n'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID " + ligneVenteDto.getArticle().getId() + " n'a ete trouve dans la BDD");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("One or more articles were not found in the DB, {}", errors);
            throw new InvalidEntityException("Un ou plusieurs articles n'ont pas ete trouve dans la BDD", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        Vente savedVentes = ventesRepository.save(VenteDto.toEntity(dto));

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVentes(savedVentes);
            LigneVente savedLigneVente = ligneVenteRepository.save(ligneVente);
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            article.get().getLigneVentes().add(savedLigneVente);
            articleRepository.save(article.get());

            // updateMvtStk(ligneVente);
        });

        return VenteDto.fromEntity(savedVentes);
    }

    @Override
    public VenteDto findById(Integer id) {
        if (id == null) {
            log.error("Ventes ID is NULL");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun vente n'a ete trouve dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public List<VenteDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
