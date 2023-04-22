package com.digitalsouag.redditapi.service;

import com.digitalsouag.redditapi.dto.RegisterDto;
import com.digitalsouag.redditapi.entity.NotificationEmail;
import com.digitalsouag.redditapi.entity.User;
import com.digitalsouag.redditapi.entity.VerificationToken;
import com.digitalsouag.redditapi.exception.SpringRedditException;
import com.digitalsouag.redditapi.repository.UserRepository;
import com.digitalsouag.redditapi.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static com.digitalsouag.redditapi.constant.Consts.ACTIVATION_EMAIL;
import static java.time.Instant.now;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;


    @Transactional
    public void signup(RegisterDto request) {
        // Implement your own requirement logic
        User u = new User();
        u.setRegistedAt(now());
        u.setUsername(request.getUsername());
        u.setEmail(request.getEmail());
        u.setPassword(encodePassword(request.getPassword()));
        u.setEnabled(false);
        userRepository.save(u);

        String token = generateVerificationToken(u);
        String msg = mailContentBuilder.build("You are welcome to RedditCloneApp: For login," +
                "please click on the below url to active your account " +  ACTIVATION_EMAIL + "/" + token);

        // Send mail to user
        mailService.sendMail(new NotificationEmail("Please activate your account", u.getEmail(), msg));

    }

    public String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken vt = new VerificationToken();
        vt.setToken(token);
        vt.setUser(user);

        verificationTokenRepository.save(vt);
        return token;
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void verifyAccount(String token) {
        Optional<VerificationToken> vto = verificationTokenRepository.findByToken(token);
        vto.orElseThrow(() -> new SpringRedditException("Token is INVALID"));
        fetchUserAndEnable(vto.get());
    }

    @Transactional
     void fetchUserAndEnable(VerificationToken vt) {
        String username = vt.getUser().getUsername();
      User userActivated =  userRepository.findByUsername(username).orElseThrow(() ->
             new SpringRedditException("Sorry user" + username + "not found "));
        userActivated.setEnabled(true);
            userRepository.save(userActivated);
    }

}
