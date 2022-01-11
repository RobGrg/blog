package com.example.authserver.repo;

import com.example.authserver.entity.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends CrudRepository<Permission, Short> {
    Permission findByName(String name);
}
