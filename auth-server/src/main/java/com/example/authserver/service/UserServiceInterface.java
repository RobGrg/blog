package com.example.authserver.service;

import com.example.authserver.entity.Role;
import com.example.authserver.entity.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, String roleName);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
