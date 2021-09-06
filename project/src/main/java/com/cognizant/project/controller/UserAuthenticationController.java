package com.cognizant.project.controller;

import com.cognizant.project.model.AppUser;
import com.cognizant.project.model.UserAuthentication;
import com.cognizant.project.service.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class UserAuthenticationController {

    private final UserAuthenticationService userAuthenticationService;

    @GetMapping(value = "/user/{username}")
    public ResponseEntity<AppUser> getUser(@PathVariable String username) {
        return ResponseEntity.ok().body(userAuthenticationService.getAppUser(username));
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(userAuthenticationService.getUsers());
    }

    @PostMapping(value = "/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody UserAuthentication user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/user/save").toUriString());
        return ResponseEntity.created(uri).body(userAuthenticationService.saveUser(user).getAppUserId());
    }
}
