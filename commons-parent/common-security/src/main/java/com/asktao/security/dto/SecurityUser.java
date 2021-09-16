package com.asktao.security.dto;

import com.nimbusds.jose.Payload;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author wuyang
 */
@Data
public class SecurityUser implements UserDetails {

    private String username;

    private String password;

    private Collection<SimpleGrantedAuthority> authorities;

    private JwtPayload jwtPayload;

    public SecurityUser() {
        initPayload();
    }

    public SecurityUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SecurityUser(String username, String password, Collection<SimpleGrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    private void initPayload() {
        this.jwtPayload = new JwtPayload();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
