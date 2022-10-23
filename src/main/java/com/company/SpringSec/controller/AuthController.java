package com.company.SpringSec.controller;

import com.company.SpringSec.dto.UserDto;
import com.company.SpringSec.dto.UserLoginResponse;
import com.company.SpringSec.dto.request.CreateUserRequest;
import com.company.SpringSec.dto.request.SignInRequest;
import com.company.SpringSec.security.UserPrincipal;
import com.company.SpringSec.service.AuthenticationService;
import com.company.SpringSec.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final UserService userService;


    public AuthController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request){
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> signIn(@RequestBody SignInRequest request){
        return ResponseEntity.ok(authenticationService.singInAndReturnJWT(request));
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<UserLoginResponse> refreshToken(@Parameter(hidden = true)
                                                              @AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(authenticationService.refreshToken(userPrincipal));
    }

}
