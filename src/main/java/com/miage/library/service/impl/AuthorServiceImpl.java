package com.miage.library.service.impl;

import com.miage.library.dao.AuthorDao;
import com.miage.library.domain.Author;
import com.miage.library.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Author}.
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    @Autowired
    private AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    /**
     * Save a author.
     *
     * @param author the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Author save(Author author) {
        log.debug("Request to save Author : {}", author);
        return authorDao.save(author);
    }

    /**
     * Get all the authors.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        log.debug("Request to get all Authors");
        return authorDao.findAll();
    }

    /**
     * Get one author by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findOne(Long id) {
        log.debug("Request to get Author : {}", id);
        return authorDao.findById(id);
    }

    /**
     * Delete the author by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Author : {}", id);
        authorDao.deleteById(id);
    }
}
