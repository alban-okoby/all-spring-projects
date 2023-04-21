package com.digitalsouag.redditapi.service;

import com.digitalsouag.redditapi.dto.RegisterDto;
import com.digitalsouag.redditapi.entity.User;

public interface AuthService {
    void signup(RegisterDto request);
    String encodePassword(String password);
    String generateVerificationToken(User user);
}
