package com.miage.library.service;

import com.miage.library.domain.Category;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Category}.
 */
public interface CategoryService {

    Category save(Category category);

    List<Category> findAll();


    Optional<Category> findOne(Long id);

    void delete(Long id);
}
