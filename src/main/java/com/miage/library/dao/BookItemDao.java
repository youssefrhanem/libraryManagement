package com.miage.library.dao;



import com.miage.library.domain.BookItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookItemDao extends CrudRepository<BookItem, Long> {
}
