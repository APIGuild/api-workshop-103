package com.tw.apiguild.controller;

import com.tw.apiguild.constant.ApplicationConstants;
import com.tw.apiguild.controller.dto.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping(path = "greeting")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello!");
    }

    @GetMapping(path = "security/greeting")
    public ResponseEntity<String> greeting(@AuthenticationPrincipal UserDetails userDetails) {
        String message = "Hello, authenticated user, " + userDetails.getUsername() + "!";
        return ResponseEntity.ok(message);
    }

    @GetMapping(path = "jwt/greeting")
    public ResponseEntity<String> greetingViaJWT() {
        String message = "Hello, authenticated user, " +  SecurityContextHolder.getContext().getAuthentication().getName() + "!";
        return ResponseEntity.ok(message);
    }

    @PostMapping(path = "login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String compactJws = Jwts.builder()
                .setSubject(loginRequest.getUsername())
                .signWith(SignatureAlgorithm.HS512, ApplicationConstants.KEY)
                .compact();
        return ResponseEntity.ok(compactJws);
    }
}
