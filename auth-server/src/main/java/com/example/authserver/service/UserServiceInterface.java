package com.example.authserver.service;

import com.example.authserver.entity.Permission;
import com.example.authserver.entity.Role;
import com.example.authserver.entity.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);

    Role saveRole(Role role);

    Permission savePermission(Permission permission);

    void addRoleToUser(String userName, String roleName);

    User getUserByUsername(String username);

    List<User> getAllUsers();

    void addRoleToPermisison(String roleName, String permissionName);
}
