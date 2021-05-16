package com.example.aclresource.service.impl;

import com.example.aclresource.model.Grant;
import com.example.aclresource.model.PartyGrant;
import com.example.aclresource.repository.GrantRepository;
import com.example.aclresource.repository.PartyGrantRepository;
import com.example.aclresource.service.GrantService;
import com.example.aclresource.validation.Validator;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DefaultGrantService implements GrantService {

    private GrantRepository grantRepository;
    private PartyGrantRepository partyGrantRepository;
    private Validator<Grant> validator;

    @Override
    public Grant save(Grant grant) {
        validator.validate(grant);
        return grantRepository.save(grant);
    }

    // TODO: cancella anche le afferenze
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

    // This code is potentially inefficient, a findIn would be faster.
    // Not used here because the volumes of requests is presumably low.
    // Enhance in case of need.
    @Override
    public List<Grant> findByPartyId(Long partyId) {
        return partyGrantRepository.findByPartyId(partyId).stream()
                .map(PartyGrant::getGrantId)
                .map(grantRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public List<Grant> findAll() {
        return grantRepository.findAll();
    }
}
