package com.example.authserver.service;

import com.example.authserver.entity.Permission;
import com.example.authserver.entity.Role;
import com.example.authserver.entity.User;
import com.example.authserver.repo.PermissionRepo;
import com.example.authserver.repo.RoleRepo;
import com.example.authserver.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService implements UserServiceInterface {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PermissionRepo permissionRepo;

    @Override
    public User saveUser(User user) {
        if (userRepo.findByUserName(user.getUserName()) != null) {
            throw new IllegalArgumentException("User name has already been created witht the name " + user.getUserName());
        }
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        if (roleRepo.findByName(role.getName()) != null) {
            throw new IllegalArgumentException("Role has already been created with the name " + role.getName());
        }
        return roleRepo.save(role);
    }

    @Override
    public Permission savePermission(Permission permission) {
        if (permissionRepo.findByName(permission.getName()) != null) {
            throw new IllegalArgumentException("Role has already been created with the name " + permission.getName());
        }
        return permissionRepo.save(permission);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepo.findByUserName(userName);
        Role role = roleRepo.findByName(roleName);
        user.setRole(role);
        userRepo.save(user);
    }


    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUserName(username);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public void addRoleToPermisison(String roleName, String permissionName) {
        Role role = roleRepo.findByName(roleName);
        Permission permission = permissionRepo.findByName(permissionName);

        role.getPermissions().add(permission);
        permission.getRoles().add(role);

        roleRepo.save(role);
    }
}
