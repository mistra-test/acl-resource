package com.example.aclresource.service;

import com.example.aclresource.model.Grant;
import com.example.aclresource.repository.GrantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GrantService {

    private GrantRepository grantRepository;

    @Autowired
    public GrantService(GrantRepository grantRepository) {
        this.grantRepository = grantRepository;
    }

    public Grant save(Grant grant) {
        return grantRepository.save(grant);
    }

    public void deleteById(Long id) {
        grantRepository.deleteById(id);
    }

    public Optional<Grant> findById(Long id) {
        return grantRepository.findById(id);
    }
}
