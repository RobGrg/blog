package com.example.authserver.repo;

import com.example.authserver.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client,Long> {
    Client findClientByClientId(String clientId);
}
