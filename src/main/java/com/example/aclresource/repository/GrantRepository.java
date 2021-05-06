package com.example.aclresource.repository;

import com.example.aclresource.model.Grant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GrantRepository extends JpaRepository<Grant, Long> {

    @Query(
            "SELECT g FROM Grant g, PartyGrant pg, UserParty up"
                    + " WHERE up.userId = :userId"
                    + " AND up.partyId = pg.partyId"
                    + " AND pg.grantId = g.id")
    List<Grant> findByUserId(Long userId);
}
