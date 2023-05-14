package com.digitalsouag.security.config;

import com.digitalsouag.security.entity.User;
import com.digitalsouag.security.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = usersRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("This user isn't present"));
        return user;
    }
    public void newUser(UserDetails user) {
        usersRepository.save((User) user);
    }
}
