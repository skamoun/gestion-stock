package com.kamoun.gestiondestock.services.Impl;

import com.kamoun.gestiondestock.dtos.CommandeClientDto;
import com.kamoun.gestiondestock.dtos.LigneCommandeClientDto;
import com.kamoun.gestiondestock.exception.EntityNotFoundException;
import com.kamoun.gestiondestock.exception.ErrorCodes;
import com.kamoun.gestiondestock.exception.InvalidEntityException;
import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.model.Client;
import com.kamoun.gestiondestock.model.CommandeClient;
import com.kamoun.gestiondestock.model.LigneCommandeClient;
import com.kamoun.gestiondestock.repository.ArticleRepository;
import com.kamoun.gestiondestock.repository.ClientRepository;
import com.kamoun.gestiondestock.repository.CommandeClientRepository;
import com.kamoun.gestiondestock.repository.LigneCommandeClientRepository;
import com.kamoun.gestiondestock.services.CommandeClientService;
import com.kamoun.gestiondestock.validator.CommandeClientValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CommandeClientServiceImpl implements CommandeClientService {
    private final CommandeClientRepository commandeClientRepository;
    private final ArticleRepository articleRepository;
    private final ClientRepository clientRepository;
    private final LigneCommandeClientRepository ligneCommandeClientRepository;

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("la commande client n'est pas valide",
                    ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }
        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()) {
            log.warn("Client with ID:{} not found in database", dto.getClient().getId());
            throw new EntityNotFoundException("Client not found in DB", ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                if (ligCmdClt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("L'article avec l'ID " + ligCmdClt.getArticle().getId() + " n'existe pas");
                    }
                } else {
                    articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }
        dto.setDateCommande(Instant.now());
        CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommandeClient(savedCmdClt);
                if (ligCmdClt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                    article.ifPresent(ligneCommandeClient::setArticle);
                }
                ligneCommandeClient.setIdEntreprise(dto.getIdEntreprise());
                LigneCommandeClient savedLigneCmd = ligneCommandeClientRepository.save(ligneCommandeClient);

            });
        }
        return CommandeClientDto.fromEntity(savedCmdClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if (id == null) {
            log.error("Article with ID : {} is null", id);
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune commande client trouvée avec l'id =" +
                        id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Article with code : {} is null", code);
            return null;
        }
        return commandeClientRepository.findByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune commande client trouvée avec le code =" +
                        code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article with ID : {} is null", id);
            return;
        }
        commandeClientRepository.deleteById(id);
    }
}
