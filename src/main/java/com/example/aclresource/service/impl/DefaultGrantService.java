package com.example.aclresource.service.impl;

import com.example.aclresource.model.Grant;
import com.example.aclresource.repository.GrantRepository;
import com.example.aclresource.repository.PartyRepository;
import com.example.aclresource.repository.UserPartyRepository;
import com.example.aclresource.service.GrantService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DefaultGrantService implements GrantService {

    private GrantRepository grantRepository;
    private PartyRepository partyRepository;
    private UserPartyRepository userPartyRepository;

    @Override
    public Grant save(Grant grant) {
        return grantRepository.save(grant);
    }

    @Override
    public void deleteById(Long id) {
        grantRepository.deleteById(id);
    }

    @Override
    public Optional<Grant> findById(Long id) {
        return grantRepository.findById(id);
    }

    @Override
    public List<String> findByUserId(Long userId) {
        return grantRepository.findByUserId(userId).stream()
                .map(Grant::getName)
                .collect(Collectors.toList());
    }
}
