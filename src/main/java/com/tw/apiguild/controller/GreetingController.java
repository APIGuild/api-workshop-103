package com.tw.apiguild.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping(path = "greeting")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello!");
    }

    @GetMapping(path = "security/greeting")
    public ResponseEntity<String> greeting(@AuthenticationPrincipal UserDetails userDetails) {
        String message = "Hello Authenticated User, " + userDetails.getUsername() + "!";
        return ResponseEntity.ok(message);
    }
}
