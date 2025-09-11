package com.jobhaven.authservice.dto;

import com.jobhaven.common.domain.Role;
import lombok.Data;

@Data
public class ChangeRoleRequest {

    private String username;
    private Role newRole;
}
