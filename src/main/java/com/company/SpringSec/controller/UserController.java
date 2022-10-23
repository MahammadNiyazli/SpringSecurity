package com.company.SpringSec.controller;

import com.company.SpringSec.dto.UserDto;
import com.company.SpringSec.dto.request.CreateUserRequest;
import com.company.SpringSec.model.User;
import com.company.SpringSec.security.UserPrincipal;
import com.company.SpringSec.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

   private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/findAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(@Parameter(hidden = true)
                                                         @AuthenticationPrincipal UserPrincipal userPrincipal){
        System.err.println("userPrincipal = "+userPrincipal);
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<User> findById(@Parameter(hidden = true)
                                             @AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(userService.findUserByPin(userPrincipal.getUsername()));
    }



}
