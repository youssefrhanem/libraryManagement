package com.miage.library.dao;

import com.miage.library.domain.security.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
