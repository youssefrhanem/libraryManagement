package com.miage.library.service;

import com.miage.library.domain.BookReservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link BookReservation}.
 */
public interface BookReservationService {

    BookReservation save(BookReservation bookReservation);

    List<BookReservation> findAll();

    List<BookReservation> findAllWhereBookLendingIsNull();

    Optional<BookReservation> findOne(Long id);

    void delete(Long id);
}
