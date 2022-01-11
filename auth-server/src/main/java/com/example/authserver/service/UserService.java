package com.example.authserver.service;

import com.example.authserver.entity.Role;
import com.example.authserver.entity.User;
import com.example.authserver.repo.RoleRepo;
import com.example.authserver.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService implements UserServiceInterface{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public User saveUser(User user) {
        if(userRepo.findByUserName(user.getUserName()) !=null){
            throw new IllegalArgumentException();
        }
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepo.findByUserName(userName);
        Role role = roleRepo.findByName(roleName);
        user.setRole(role);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUserName(username);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }
}
