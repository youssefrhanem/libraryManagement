package com.miage.library.service.impl;


import com.miage.library.dao.MemberDao;
import com.miage.library.domain.Member;
import com.miage.library.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Member}.
 */
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberDao memberDao;


    /**
     * Save a member.
     *
     * @param member the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Member save(Member member) {
        log.debug("Request to save Member : {}", member);
        return memberDao.save(member);
    }

    /**
     * Get all the members.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Member> findAll() {
        log.debug("Request to get all Members");
        return (List<Member>)memberDao.findAll();
    }

    /**
     * Get one member by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Member> findOne(Long id) {
        log.debug("Request to get Member : {}", id);
        return memberDao.findById(id);
    }

    /**
     * Delete the member by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Member : {}", id);
        memberDao.deleteById(id);
    }
}
