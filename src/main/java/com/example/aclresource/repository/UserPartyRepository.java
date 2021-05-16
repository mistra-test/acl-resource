package com.example.aclresource.repository;

import com.example.aclresource.model.UserParty;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPartyRepository extends JpaRepository<UserParty, Long> {
    List<UserParty> findByUserId(Long userId);

    List<UserParty> findByPartyId(Long partyId);

    void deleteByPartyId(Long partyId);
}
