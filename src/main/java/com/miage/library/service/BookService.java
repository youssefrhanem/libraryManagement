package com.miage.library.service;

import com.miage.library.domain.Book;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface BookService {


    Book save(Book book);

    Book add(MultipartFile file, String iSBN,
             String title, String subject,
             String publisher, String language,
             Integer numberOfPages,
             Long authors, Long categories) throws IOException;


    List<Book> findAll();

    Book findOne(Long id);

    void delete(Long id);
}
