package com.miage.library.domain.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by YOUSSEF on 10/05/20.
 */


public class Authority implements GrantedAuthority {

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
