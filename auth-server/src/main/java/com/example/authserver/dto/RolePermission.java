package com.example.authserver.dto;

import lombok.Data;

@Data
public class RolePermission {
    private String roleName;
    private String permissionName;
}
