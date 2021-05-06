package com.example.aclresource.service;

import com.example.aclresource.model.Grant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GrantService {

    public Grant save(Grant grant);

    public void deleteById(Long id);

    public Optional<Grant> findById(Long id);

    List<String> findByUserId(Long userId);
}
