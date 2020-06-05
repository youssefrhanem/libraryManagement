package com.miage.library.dao;



import com.miage.library.domain.Book;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookDao extends JpaRepository<Book, Long> {


   /*  @Query("select distinct book from Book book left join fetch book.authors left join fetch book.categories")
    List<Book> findAllWithEagerRelationships();

    @Query("select book from Book book left join fetch book.authors left join fetch book.categories where book.id =:id")
    Optional<Book> findOneWithEagerRelationships(@Param("id") Long id);*/
}
