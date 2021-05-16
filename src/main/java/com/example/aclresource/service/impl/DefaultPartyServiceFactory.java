package com.example.aclresource.service.impl;

import com.example.aclresource.repository.GrantRepository;
import com.example.aclresource.repository.PartyGrantRepository;
import com.example.aclresource.repository.PartyRepository;
import com.example.aclresource.repository.UserPartyRepository;
import com.example.aclresource.service.PartyService;
import com.example.aclresource.validation.PartyValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultPartyServiceFactory {

    @Bean
    @Autowired
    public PartyService getDefaultPartyService(
            PartyRepository partyRepository,
            GrantRepository grantRepository,
            PartyGrantRepository partyGrantRepository,
            UserPartyRepository userPartyRepository,
            PartyValidator partyValidator) {
        return new DefaultPartyService(
                partyRepository,
                grantRepository,
                partyGrantRepository,
                userPartyRepository,
                partyValidator);
    }
}
