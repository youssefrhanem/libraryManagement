package com.miage.library.dao;

import com.miage.library.domain.LibraryCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardDao extends CrudRepository<LibraryCard, Long> {
}
