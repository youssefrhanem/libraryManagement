package com.miage.library.dao;

import com.miage.library.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberDao extends CrudRepository<Member, Long> {
}
