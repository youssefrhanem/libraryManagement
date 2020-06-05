package com.miage.library.service.impl;


import com.miage.library.dao.BookReservationDao;
import com.miage.library.domain.BookReservation;
import com.miage.library.service.BookReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing {@link BookReservation}.
 */
@Service
@Transactional
public class BookReservationServiceImpl implements BookReservationService {

    private final Logger log = LoggerFactory.getLogger(BookReservationServiceImpl.class);


    @Autowired
    private  BookReservationDao bookReservationDao;


    /**
     * Save a bookReservation.
     *
     * @param bookReservation the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BookReservation save(BookReservation bookReservation) {
        log.debug("Request to save BookReservation : {}", bookReservation);
        return bookReservationDao.save(bookReservation);
    }

    /**
     * Get all the bookReservations.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<BookReservation> findAll() {
        log.debug("Request to get all BookReservations");
        return (List<BookReservation>) bookReservationDao.findAll();
    }

    /**
     *  Get all the bookReservations where BookLending is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<BookReservation> findAllWhereBookLendingIsNull() {
        log.debug("Request to get all bookReservations where BookLending is null");
        return StreamSupport
            .stream(bookReservationDao.findAll().spliterator(), false)
            .filter(bookReservation -> bookReservation.getBookLending() == null)
            .collect(Collectors.toList());
    }

    /**
     * Get one bookReservation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BookReservation> findOne(Long id) {
        log.debug("Request to get BookReservation : {}", id);
        return bookReservationDao.findById(id);
    }

    /**
     * Delete the bookReservation by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BookReservation : {}", id);
        bookReservationDao.deleteById(id);
    }
}
