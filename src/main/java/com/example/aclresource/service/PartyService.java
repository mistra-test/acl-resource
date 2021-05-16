package com.example.aclresource.service;

import com.example.aclresource.model.Party;
import com.example.aclresource.model.PartyGrant;
import com.example.aclresource.model.UserParty;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartyService {
    public List<Party> findAll();

    public List<Long> findAssignedUserIdList(Long partyId);

    public PartyGrant assignGrant(Long partyId, Long grantId);

    public void removeGrant(Long partyId, Long grantId);

    public UserParty assignUserId(Long partyId, Long userId);

    public void removeUser(Long partyId, Long userId);

    public Party save(Party party);

    public void deleteById(Long partyId);
}
