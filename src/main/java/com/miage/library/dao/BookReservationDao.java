package com.miage.library.dao;

import com.miage.library.domain.BookReservation;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookReservationDao extends CrudRepository<BookReservation, Long> {


   /*  @Query("select distinct bookReservation from BookReservation bookReservation left join fetch bookReservation.members left join fetch bookReservation.bookItems")
    List<BookReservation> findAllWithEagerRelationships();

   @Query("select bookReservation from BookReservation bookReservation left join fetch bookReservation.members left join fetch bookReservation.bookItems where bookReservation.id =:id")
    Optional<BookReservation> findOneWithEagerRelationships(@Param("id") Long id);*/
}
