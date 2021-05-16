package com.example.aclresource.repository;

import com.example.aclresource.model.PartyGrant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyGrantRepository extends JpaRepository<PartyGrant, Long> {

    List<PartyGrant> findByPartyId(Long partyId);

    List<PartyGrant> findByGrantId(Long grantId);

    void deleteByPartyId(Long partyId);
}
