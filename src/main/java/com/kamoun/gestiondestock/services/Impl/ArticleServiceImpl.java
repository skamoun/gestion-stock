package com.kamoun.gestiondestock.services.Impl;

import com.kamoun.gestiondestock.dtos.ArticleDto;
import com.kamoun.gestiondestock.exception.EntityNotFoundException;
import com.kamoun.gestiondestock.exception.ErrorCodes;
import com.kamoun.gestiondestock.exception.InvalidEntityException;
import com.kamoun.gestiondestock.repository.ArticleRepository;
import com.kamoun.gestiondestock.services.ArticleService;
import com.kamoun.gestiondestock.validator.ArticleValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()) {
            log.error("article not  valid:{}", articleDto);
            throw new InvalidEntityException("l'articel n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }
        return ArticleDto.fromEntity(articleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("l'article avec l'id " + id + "n'a pas été trouve", ErrorCodes.ARTICLE_NOT_FOUND)));
    }

    @Override
    public ArticleDto findByCode(String code) {
        if (code == null) {
            log.error("Article ID is null");
            return null;
        }
        return ArticleDto.fromEntity(articleRepository.findByCode(code)
                .orElseThrow(() ->
                        new EntityNotFoundException("l'article avec le  " + code + "n'a pas été trouve",
                                ErrorCodes.ARTICLE_NOT_FOUND)));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }
        articleRepository.deleteById(id);
    }
}
