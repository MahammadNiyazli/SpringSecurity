package com.company.SpringSec.controller;

import com.company.SpringSec.dto.request.SignInRequest;
import com.company.SpringSec.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest request){
        return ResponseEntity.ok(authenticationService.singInAndReturnJWT(request));
    }

}
