package com.miage.library.service.impl;


import com.miage.library.dao.AuthorDao;
import com.miage.library.dao.BookDao;
import com.miage.library.dao.CategoryDao;
import com.miage.library.domain.Author;
import com.miage.library.domain.Book;
import com.miage.library.domain.Category;
import com.miage.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Book}.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private CategoryDao categoryDao;


    /**
     * Save a book.
     *
     * @param book the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Book save(Book book) {
        log.debug("Request to save Book : {}", book);
        return bookDao.save(book);
    }

    @Override
    public Book add(MultipartFile file, String iSBN, String title, String subject, String publisher, String language, Integer numberOfPages, Long authors, Long categories) throws IOException {

        Author author = authorDao.getOne(authors);

        Category category = categoryDao.getOne(categories);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileType = file.getContentType();


        Book book = new Book(iSBN,title,subject,publisher,language,numberOfPages,file.getBytes(),fileName, fileType, author, category);

        return bookDao.save(book);
    }


    /**
     * Get all the books.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        log.debug("Request to get all Books");
        return (List<Book>) bookDao.findAll();
    }



    /**
     * Get one book by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Book findOne(Long id) {
        log.debug("Request to get Book : {}", id);
        return bookDao.getOne(id);
    }

    /**
     * Delete the book by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Book : {}", id);
        bookDao.deleteById(id);
    }
}
