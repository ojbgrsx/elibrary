package com.example.elibrary.entity;

import ch.qos.logback.core.status.Status;
import com.example.elibrary.entity.base.BaseEntity;
import com.example.elibrary.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;


public class User extends BaseEntity implements UserDetails {

    @Column(name = "user_name")
    String userName;

    //TODO: почта нужна или
    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "url_image")
    String urlImage;

    @Column(name = "last_visit_date")
    LocalDateTime lastVisitDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;
    
    //TODO: READ
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    //TODO :
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
