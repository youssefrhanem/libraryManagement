package com.miage.library.service.impl;


import com.miage.library.dao.LibraryCardDao;
import com.miage.library.domain.LibraryCard;
import com.miage.library.service.LibraryCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link LibraryCard}.
 */
@Service
@Transactional
public class LibraryCardServiceImpl implements LibraryCardService {

    private final Logger log = LoggerFactory.getLogger(LibraryCardServiceImpl.class);

    @Autowired
    private LibraryCardDao libraryCardDao;

    /**
     * Save a libraryCard.
     *
     * @param libraryCard the entity to save.
     * @return the persisted entity.
     */
    @Override
    public LibraryCard save(LibraryCard libraryCard) {
        log.debug("Request to save LibraryCard : {}", libraryCard);
        return libraryCardDao.save(libraryCard);
    }

    /**
     * Get all the libraryCards.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<LibraryCard> findAll() {
        log.debug("Request to get all LibraryCards");
        return (List<LibraryCard>) libraryCardDao.findAll();
    }

    /**
     * Get one libraryCard by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<LibraryCard> findOne(Long id) {
        log.debug("Request to get LibraryCard : {}", id);
        return libraryCardDao.findById(id);
    }

    /**
     * Delete the libraryCard by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete LibraryCard : {}", id);
        libraryCardDao.deleteById(id);
    }
}
