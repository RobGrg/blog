package com.example.authserver.repo;

import com.example.authserver.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Short> {
    Role findByName(String name);
}
