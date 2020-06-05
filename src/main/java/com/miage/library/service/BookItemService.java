package com.miage.library.service;

import com.miage.library.domain.Book;
import com.miage.library.domain.BookItem;
import com.miage.library.domain.Rack;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;


public interface BookItemService {


    BookItem save(BookItem bookItem);



    BookItem add(Long book, Long rack, String isReferenceOnly, String borrowed, String dueDate, String format, String status, String dateOfPurchase, String publicationDate) throws ParseException, DataFormatException;

    List<BookItem> findAll();

    Optional<BookItem> findOne(Long id);

    void delete(Long id);
}
