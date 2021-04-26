package com.example.aclresource.repository;

import com.example.aclresource.model.GroupEdge;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupEdgeRepository extends JpaRepository<GroupEdge, Long> {
    public List<GroupEdge> findBySource(Long source);
}
