package com.example.authserver.repo;

import com.example.authserver.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUserName(String username);
}
