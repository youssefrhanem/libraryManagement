package com.miage.library.service.impl;


import com.miage.library.dao.BookItemDao;
import com.miage.library.domain.Book;
import com.miage.library.domain.BookItem;
import com.miage.library.domain.Rack;
import com.miage.library.service.BookItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

/**
 * Service Implementation for managing {@link BookItem}.
 */
@Service
@Transactional
public class BookItemServiceImpl implements BookItemService {

    private final Logger log = LoggerFactory.getLogger(BookItemServiceImpl.class);

    @Autowired
    private BookItemDao bookItemDao;

    @Autowired
    BookServiceImpl bookServiceImpl;

    @Autowired
    RackServiceImpl rackServiceImpl;



    /**
     * Save a bookItem.
     *
     * @param bookItem the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BookItem save(BookItem bookItem) {
        log.debug("Request to save BookItem : {}", bookItem);
        return bookItemDao.save(bookItem);
    }

    @Override
    public BookItem add(Long idBook, Long idRack, String isReferenceOnly, String borrowed, String dueDate, String format, String status, String dateOfPurchase, String publicationDate) throws ParseException, DataFormatException {

        Book book = bookServiceImpl.findOne(idBook);
        Rack rack = rackServiceImpl.findOne(idRack);

        BookItem bookItem = new BookItem();

        bookItem.setBook(book);
        bookItem.setRack(rack);
        bookItem.setFormat(format);
        bookItem.setStatus(status);
        bookItem.setIsReferenceOnly(Boolean.parseBoolean(isReferenceOnly));
        bookItem.setBorrowed(bookItem.parseDate(borrowed));
        bookItem.setDateOfPurchase(bookItem.parseDate(dateOfPurchase));
        bookItem.setDueDate(bookItem.parseDate(dueDate));
        bookItem.setPublicationDate(bookItem.parseDate(publicationDate));
        bookItemDao.save(bookItem);

        return  bookItem;
    }


    /**
     * Get all the bookItems.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<BookItem> findAll() {
        log.debug("Request to get all BookItems");
        return (List<BookItem>) bookItemDao.findAll();
    }

    /**
     * Get one bookItem by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BookItem> findOne(Long id) {
        log.debug("Request to get BookItem : {}", id);
        return bookItemDao.findById(id);
    }

    /**
     * Delete the bookItem by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BookItem : {}", id);
        bookItemDao.deleteById(id);
    }
}
