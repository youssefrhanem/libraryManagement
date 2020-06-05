package com.miage.library.service.impl;


import com.miage.library.dao.CategoryDao;
import com.miage.library.domain.Category;
import com.miage.library.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Category}.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDao categoryDao;

    /**
     * Save a category.
     *
     * @param category the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Category save(Category category) {
        log.debug("Request to save Category : {}", category);
        return categoryDao.save(category);
    }

    /**
     * Get all the categories.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        log.debug("Request to get all Categories");
        return (List<Category>) categoryDao.findAll();
    }

    /**
     * Get one category by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Category> findOne(Long id) {
        log.debug("Request to get Category : {}", id);
        return categoryDao.findById(id);
    }

    /**
     * Delete the category by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        categoryDao.deleteById(id);
    }
}
