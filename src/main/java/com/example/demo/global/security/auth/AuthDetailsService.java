package com.example.demo.global.security.auth;

import com.example.demo.domain.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class AuthDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .map(AuthDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("유저를 찾을 수 없습니다"));
    }
}
