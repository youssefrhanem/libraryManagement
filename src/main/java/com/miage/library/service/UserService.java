package com.miage.library.service;

import com.miage.library.domain.User;
import com.miage.library.domain.security.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

    public void save(User user);

    public User findByUsername(String username);

    public User findByEmail(String email) ;


    public User createUser(User user, Set<UserRole> userRoles) ;


    public boolean checkUserExists(String username, String email);

    public boolean checkUsernameExists(String username);

    public boolean checkEmailExists(String email);

    public User saveUser (User user);

    public List<User> findUserList();

    public void enableUser (String username);

    public void disableUser (String username) ;


    public void remove (String username) ;
}
