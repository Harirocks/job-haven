package com.jobhaven.authservice.service;

import com.jobhaven.authservice.dto.LoginRequest;
import com.jobhaven.authservice.dto.RegisterRequest;
import com.jobhaven.authservice.entity.User;
import com.jobhaven.common.domain.Role;

public interface AuthService {

    void register(RegisterRequest req);

    String login(LoginRequest req);

    void changeRole(String username, Role newRole);

    User getByUsername(String username);
}
