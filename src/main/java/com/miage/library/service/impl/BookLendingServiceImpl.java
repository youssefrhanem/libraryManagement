package com.miage.library.service.impl;


import com.miage.library.dao.BookLendingDao;
import com.miage.library.domain.BookLending;
import com.miage.library.service.BookLendingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link BookLending}.
 */
@Service
@Transactional
public class BookLendingServiceImpl implements BookLendingService {

    private final Logger log = LoggerFactory.getLogger(BookLendingServiceImpl.class);

    @Autowired
    private BookLendingDao bookLendingDao;

    /**
     * Save a bookLending.
     *
     * @param bookLending the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BookLending save(BookLending bookLending) {
        log.debug("Request to save BookLending : {}", bookLending);
        return bookLendingDao.save(bookLending);
    }

    /**
     * Get all the bookLendings.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<BookLending> findAll() {
        log.debug("Request to get all BookLendings");
        return (List<BookLending>) bookLendingDao.findAll();
    }

    /**
     * Get one bookLending by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BookLending> findOne(Long id) {
        log.debug("Request to get BookLending : {}", id);
        return bookLendingDao.findById(id);
    }

    /**
     * Delete the bookLending by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BookLending : {}", id);
        bookLendingDao.deleteById(id);
    }
}
