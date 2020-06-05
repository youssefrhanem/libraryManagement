package com.miage.library.dao;


import com.miage.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	User findByEmail(String email);
	User removeByUsername(String username);


}
