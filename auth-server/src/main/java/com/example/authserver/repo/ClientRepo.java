package com.example.authserver.repo;

import com.example.authserver.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client,Long> {
    Client findClientByClientId(String clientId);
}
