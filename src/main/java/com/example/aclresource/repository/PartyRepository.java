package com.example.aclresource.repository;

import com.example.aclresource.model.Party;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {}
