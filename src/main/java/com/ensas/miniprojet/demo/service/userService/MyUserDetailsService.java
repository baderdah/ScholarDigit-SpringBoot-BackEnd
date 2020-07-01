package com.ensas.miniprojet.demo.service.userService;

import com.ensas.miniprojet.demo.dto.UserDto;
import com.ensas.miniprojet.demo.repository.userRepository.ProfRepository;
import com.ensas.miniprojet.demo.repository.userRepository.ScholarityAgentRepository;
import com.ensas.miniprojet.demo.repository.userRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ScholarityAgentRepository agentRepository;

    @Autowired
    ProfRepository profRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("search for user by username " + s);
        com.ensas.miniprojet.demo.entity.User user = studentRepository.findByEmail(s);
        if( user == null )
            user = agentRepository.findByEmail(s);
        if( user == null)
            user = profRepository.findByEmail(s);


        System.out.println( user.getNom() + user.getClass());

        UserDto userDto = new UserDto(user);

        System.out.println(userDto);

        return userDto;

    }
}