package com.miage.library.dao;

import com.miage.library.domain.BookLending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookLendingDao extends CrudRepository<BookLending, Long> {
}
