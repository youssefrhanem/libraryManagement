package com.miage.library.dao;

import com.miage.library.domain.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackDao extends JpaRepository<Rack, Long> {
}
