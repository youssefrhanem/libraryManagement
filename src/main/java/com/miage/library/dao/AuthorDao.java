package com.miage.library.dao;


import com.miage.library.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface AuthorDao extends JpaRepository<Author, Long> {


}
