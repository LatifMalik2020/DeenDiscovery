package com.provisionTechAdvisors.DeenDiscovery.service;

import com.provisionTechAdvisors.DeenDiscovery.model.User;
import com.provisionTechAdvisors.DeenDiscovery.repository.UserRepository;

import com.provisionTechAdvisors.DeenDiscovery.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username : " + username)
                );

        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList() // You should assign real authorities as needed
        );
    }
}
