package com.digitalsouag.redditapi.api;

import com.digitalsouag.redditapi.dto.RegisterDto;
import com.digitalsouag.redditapi.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.digitalsouag.redditapi.constant.constants.API_BASE_PATH;

@RestController
@RequestMapping(API_BASE_PATH + "/auth")
@AllArgsConstructor
public class AuthResource {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity register(@RequestBody RegisterDto request) {
        authService.signup(request);
        return new ResponseEntity(HttpStatus.OK);
    }
}
