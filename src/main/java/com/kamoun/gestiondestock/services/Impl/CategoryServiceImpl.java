package com.kamoun.gestiondestock.services.Impl;

import com.kamoun.gestiondestock.dtos.CategoryDto;
import com.kamoun.gestiondestock.exception.EntityNotFoundException;
import com.kamoun.gestiondestock.exception.ErrorCodes;
import com.kamoun.gestiondestock.exception.InvalidEntityException;
import com.kamoun.gestiondestock.exception.InvalidOperationException;
import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.repository.ArticleRepository;
import com.kamoun.gestiondestock.repository.CategoryRepository;
import com.kamoun.gestiondestock.services.CategoryService;
import com.kamoun.gestiondestock.validator.CategoryValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ArticleRepository articleRepository;

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("La category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(CategoryDto.toEntity(dto))
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return null;
        }
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Category CODE is null");
            return null;
        }
        return categoryRepository.findCategoryByCode(code)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune category avec le CODE = " + code + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Category ID is null");
            return;
        }
        List<Article> articles = articleRepository.findAllByCategoryId(id);
        if (!articles.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
                    ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        categoryRepository.deleteById(id);
    }
}
