package com.digitalsouag.redditapi.api;

import com.digitalsouag.redditapi.dto.AuthentificationResponse;
import com.digitalsouag.redditapi.dto.LoginRequest;
import com.digitalsouag.redditapi.dto.RegisterDto;
import com.digitalsouag.redditapi.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.digitalsouag.redditapi.constant.constants.API_BASE_PATH;

@RestController
@RequestMapping(API_BASE_PATH + "/auth")
public class AuthResource {

    private final AuthService authService;
    public AuthResource(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity register(@RequestBody RegisterDto request) {
        authService.signup(request);
        return new ResponseEntity<>("User registered successfully ✅✅ ",HttpStatus.OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account is activated successfully ✅", HttpStatus.OK);
    }

    @GetMapping("/login")
    public AuthentificationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
