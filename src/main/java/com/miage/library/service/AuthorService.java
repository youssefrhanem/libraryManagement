package com.miage.library.service;

import com.miage.library.domain.Author;

import java.util.List;
import java.util.Optional;


public interface AuthorService {


    Author save(Author author);


    List<Author> findAll();


    Optional<Author> findOne(Long id);


    void delete(Long id);
}
