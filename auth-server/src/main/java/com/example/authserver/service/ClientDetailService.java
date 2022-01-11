package com.example.authserver.service;

import com.example.authserver.config.ClientDetail;
import com.example.authserver.entity.Client;
import com.example.authserver.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailService implements ClientDetailsService {
    @Autowired
    private ClientRepo cRepo;


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        Client c=cRepo.findClientByClientId(clientId);

        if(c==null)
            throw new ClientRegistrationException("client with "+clientId +" is not available");
        return new ClientDetail(c);
    }
}
