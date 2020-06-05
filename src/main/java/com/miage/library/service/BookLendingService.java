package com.miage.library.service;

import com.miage.library.domain.BookLending;

import java.util.List;
import java.util.Optional;


public interface BookLendingService {


    BookLending save(BookLending bookLending);

    List<BookLending> findAll();

    Optional<BookLending> findOne(Long id);

    void delete(Long id);
}
