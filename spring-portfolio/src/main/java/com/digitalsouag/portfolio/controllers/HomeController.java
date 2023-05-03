package com.digitalsouag.portfolio.controllers;

import com.digitalsouag.portfolio.entities.Home;
import com.digitalsouag.portfolio.services.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/home")
public class HomeController {

    private final HomeService homeService;

    @PostMapping("")
    public ResponseEntity<Home> addHome(@RequestBody Home home) throws Exception {
        Home myHome = this.homeService.create(home);
        return new ResponseEntity<>(myHome, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Home>> getHome() {
        List<Home> last = this.homeService.getHome();
        return new ResponseEntity<>(last, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Home> updateHome(@RequestBody Home home, @PathVariable("id") Long id) throws Exception {
        Home updateHome = this.homeService.update(home, id);
        return new ResponseEntity<>(updateHome, HttpStatus.OK);
    }
}
