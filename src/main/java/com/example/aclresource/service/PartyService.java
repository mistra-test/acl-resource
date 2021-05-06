package com.example.aclresource.service;

import com.example.aclresource.model.Party;
import com.example.aclresource.model.UserParty;
import com.example.aclresource.repository.PartyRepository;
import com.example.aclresource.repository.UserPartyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService {

    PartyRepository partyRepository;
    UserPartyRepository userPartyRepository;

    @Autowired
    public PartyService(PartyRepository partyRepository, UserPartyRepository userPartyRepository) {
        this.partyRepository = partyRepository;
        this.userPartyRepository = userPartyRepository;
    }

    public Party saveGroup(Party group) {
        return partyRepository.save(group);
    }

    public void assignUserToParty(Long partyId, Long userId) {
        userPartyRepository.save(new UserParty(userId, partyId));
    }
}
