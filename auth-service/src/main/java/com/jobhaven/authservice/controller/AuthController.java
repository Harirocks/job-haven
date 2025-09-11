package com.jobhaven.authservice.controller;

import com.jobhaven.authservice.dto.AuthResponse;
import com.jobhaven.authservice.dto.ChangeRoleRequest;
import com.jobhaven.authservice.dto.LoginRequest;
import com.jobhaven.authservice.dto.RegisterRequest;
import com.jobhaven.authservice.entity.User;
import com.jobhaven.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {
        authService.register(req);
        return "Registered";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {
        String token = authService.login(req);
        return new AuthResponse(token);
    }

    // Simple role-change endpoint (in real life, protect by a workflow)
    @PostMapping("/change-role")
    public String changeRole(@RequestBody ChangeRoleRequest req) {
        authService.changeRole(req.getUsername(), req.getNewRole());
        return "Role updated";
    }

    // Optional: get current user profile by username
    @GetMapping("/me/{username}")
    public User me(@PathVariable String username) {
        return authService.getByUsername(username);
    }
}
