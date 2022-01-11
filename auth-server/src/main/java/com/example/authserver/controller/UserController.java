package com.example.authserver.controller;

import com.example.authserver.dto.RolePermission;
import com.example.authserver.dto.UserRole;
import com.example.authserver.entity.Permission;
import com.example.authserver.entity.Role;
import com.example.authserver.entity.User;
import com.example.authserver.service.UserService;
import lombok.AllArgsConstructor;
import org.hibernate.hql.internal.ast.tree.ResolvableNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/getALL")
    public ResponseEntity<List<User>> getALlUser(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/user/add")
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/add").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/add")
    public ResponseEntity<Role> saveRole(@RequestBody @Valid Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/add").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtoUser")
    public ResponseEntity<?> saveRoleToUser(@RequestBody @Valid UserRole userRole){
        userService.addRoleToUser(userRole.getUserName(), userRole.getRoleName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/permission/add")
    public ResponseEntity<Permission> savePermission(@RequestBody @Valid Permission permission){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/add").toUriString());
        return ResponseEntity.created(uri).body(userService.savePermission(permission));
    }

    @PostMapping("/role/addtoUser")
    public ResponseEntity<?> saveRoleToUser(@RequestBody @Valid RolePermission rolePermission){
        userService.addRoleToUser(rolePermission.getRoleName(), rolePermission.getPermissionName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
