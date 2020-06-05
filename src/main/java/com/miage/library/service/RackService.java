package com.miage.library.service;



import com.miage.library.domain.Rack;

import java.util.List;
import java.util.Optional;


public interface RackService {


    Rack save(Rack rack);

    List<Rack> findAll();

    Rack findOne(Long id);

    void delete(Long id);
}
