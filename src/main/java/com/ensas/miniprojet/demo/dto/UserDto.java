package com.ensas.miniprojet.demo.dto;

import com.ensas.miniprojet.demo.entity.Prof;
import com.ensas.miniprojet.demo.entity.User;
import com.ensas.miniprojet.demo.entity.ScolarityAgent;
import com.ensas.miniprojet.demo.entity.Student;
import com.ensas.miniprojet.demo.model.auth.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDto implements UserDetails {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String password;

    List<GrantedAuthority> authorities;

    public UserDto(User user){
        authorities = new ArrayList<>();
        System.out.println("begin of constructor");
        username = user.getEmail();
        password = user.getIdentification().getPassword();
        System.out.println("begin of constructor 1");
        if( user.getClass().equals(Student.class)){
            authorities.add(new Authority("Student"));
        }else if( user.getClass().equals(ScolarityAgent.class)){
            authorities.add(new Authority("Scholarity"));
        }else if( user.getClass().equals(Prof.class)){
            authorities.add(new Authority("Prof"));
        }
        System.out.println("end of constructor");
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", pasword='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
