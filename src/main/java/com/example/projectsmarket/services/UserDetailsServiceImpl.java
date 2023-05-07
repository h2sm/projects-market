package com.example.projectsmarket.services;

import com.example.projectsmarket.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserEntityByUserEmailEquals(username);
        if (user != null) {
            return SecureUser.fromUser(user);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
