package com.example.authserver.service;

import com.example.authserver.config.CustomUserDetail;
import com.example.authserver.entity.User;
import com.example.authserver.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Username not found for : "+username);
        }
        return new CustomUserDetail(user);
    }
}
