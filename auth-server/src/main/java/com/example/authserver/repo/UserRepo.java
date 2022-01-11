package com.example.authserver.repo;

import com.example.authserver.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUserName(String username);
}
