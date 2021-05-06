package com.example.aclresource.service.impl;

import com.example.aclresource.repository.GrantRepository;
import com.example.aclresource.repository.PartyRepository;
import com.example.aclresource.repository.UserPartyRepository;
import com.example.aclresource.service.GrantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultGrantServiceConfig {

    @Bean
    @Autowired
    public GrantService getDefaultGrantService(
            GrantRepository grantRepository,
            PartyRepository partyRepository,
            UserPartyRepository userPartyRepository) {
        return new DefaultGrantService(grantRepository, partyRepository, userPartyRepository);
    }
}
