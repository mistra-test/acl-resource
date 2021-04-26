package com.example.aclresource.repository;

import com.example.aclresource.model.AuthGroup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<AuthGroup, Long> {}
