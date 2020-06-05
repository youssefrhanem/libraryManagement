package com.miage.library.service;

import com.miage.library.domain.LibraryCard;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link LibraryCard}.
 */
public interface LibraryCardService {


    LibraryCard save(LibraryCard libraryCard);
    List<LibraryCard> findAll();
    Optional<LibraryCard> findOne(Long id);
    void delete(Long id);
}
