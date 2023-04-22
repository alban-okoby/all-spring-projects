package com.digitalsouag.redditapi.api;

import com.digitalsouag.redditapi.dto.AuthentificationDto;
import com.digitalsouag.redditapi.dto.RegisterDto;
import com.digitalsouag.redditapi.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.digitalsouag.redditapi.constant.constants.API_BASE_PATH;

@RestController
@RequestMapping(API_BASE_PATH + "/auth")
@AllArgsConstructor
public class AuthResource {

    private final AuthService authService;

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
    public AuthentificationDto login(@RequestBody LoginReequest loginReequest) {
        return authService.login(loginReequest);
    }
}
