package com.digitalsouag.qrcode;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean validateQRCodeToken(String token) {
        // Validation du token (par exemple, vérifier s'il existe et s'il n'est pas expiré)
        return token != null && !token.isEmpty();
    }
}
