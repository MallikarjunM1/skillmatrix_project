package com.employee.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.Repository.UserRepository;
import com.employee.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nameOrEmail) throws UsernameNotFoundException {
       User user = userRepository.findBynameOrEmail(nameOrEmail, nameOrEmail)
               .orElseThrow(() ->
                       new UsernameNotFoundException("User not found with username or email:" + nameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),null);
    }
    
    
 
    
	

}