package com.pickme.pickmeappauthservice.helper;

import com.pickme.pickmeappentityservice.models.Driver;
import com.pickme.pickmeappentityservice.models.Passenger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthPassengeDetails implements UserDetails {

    private String userName;
    private String password;

    public AuthPassengeDetails(Passenger passenger) {
        this.userName = passenger.getEmail();
        this.password = passenger.getPassword();
    }

    public AuthPassengeDetails(Driver driver) {
        this.userName = driver.getEmail();
        this.password = driver.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
