package com.digitalsouag.redditapi.service.Impl;

import com.digitalsouag.redditapi.dto.RegisterDto;
import com.digitalsouag.redditapi.entity.User;
import com.digitalsouag.redditapi.entity.VerificationToken;
import com.digitalsouag.redditapi.repository.UserRepository;
import com.digitalsouag.redditapi.repository.VerificationTokenRepository;
import com.digitalsouag.redditapi.service.AuthService;
import com.digitalsouag.redditapi.service.MailContentBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static java.time.Instant.now;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

   private UserRepository userRepository;
   private PasswordEncoder passwordEncoder;
   private VerificationTokenRepository verificationTokenRepository;
   private MailContentBuilder mailContentBuilder;

    public AuthServiceImpl() {
    }


    @Override @Transactional
    public void signup(RegisterDto request) {
        // Implement your own requirement logic
        User u = new User();
            u.setRegistedAt(now());
            u.setUsername(request.getUsername());
            u.setEmail(request.getEmail());
            u.setPassword(encodePassword(request.getPassword()));
            u.setEnabled(false);

            userRepository.save(u);
    }

    @Override
    public String generateVerificationToken(User user) {
       String token = UUID.randomUUID().toString();
        VerificationToken vt = new VerificationToken();
            vt.setToken(token);
            vt.setUser(user);

            verificationTokenRepository.save(vt);
       return token;
    }


    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
