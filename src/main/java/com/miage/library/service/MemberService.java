package com.miage.library.service;
import com.miage.library.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberService {


    Member save(Member member);
    List<Member> findAll();
    Optional<Member> findOne(Long id);
    void delete(Long id);
}
