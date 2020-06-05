package com.miage.library.service.impl;


import com.miage.library.dao.RackDao;
import com.miage.library.domain.Rack;
import com.miage.library.service.RackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Rack}.
 */
@Service
@Transactional
public class RackServiceImpl implements RackService {

    private final Logger log = LoggerFactory.getLogger(RackServiceImpl.class);

    @Autowired
    private RackDao rackDao;


    /**
     * Save a rack.
     *
     * @param rack the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Rack save(Rack rack) {
        log.debug("Request to save Rack : {}", rack);
        return rackDao.save(rack);
    }

    /**
     * Get all the racks.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Rack> findAll() {
        log.debug("Request to get all Racks");
        return (List<Rack>) rackDao.findAll();
    }

    /**
     * Get one rack by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Rack findOne(Long id) {
        log.debug("Request to get Rack : {}", id);
        return rackDao.getOne(id);
    }

    /**
     * Delete the rack by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Rack : {}", id);
        rackDao.deleteById(id);
    }
}
