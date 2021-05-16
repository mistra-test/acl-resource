package com.example.aclresource.service.impl;

import com.example.aclresource.repository.GrantRepository;
import com.example.aclresource.repository.PartyGrantRepository;
import com.example.aclresource.service.GrantService;
import com.example.aclresource.validation.GrantValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultGrantServiceFactory {

    @Bean
    @Autowired
    public GrantService getDefaultGrantService(
            GrantRepository grantRepository,
            PartyGrantRepository partyGrantRepository,
            GrantValidator grantValidator) {
        return new DefaultGrantService(grantRepository, partyGrantRepository, grantValidator);
    }
}
