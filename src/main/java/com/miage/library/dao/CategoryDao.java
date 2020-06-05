package com.miage.library.dao;

import com.miage.library.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {
}
