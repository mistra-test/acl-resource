package com.example.aclresource.service.impl;

import com.example.aclresource.exception.EntityNotFoundException;
import com.example.aclresource.model.Party;
import com.example.aclresource.model.PartyGrant;
import com.example.aclresource.model.UserParty;
import com.example.aclresource.repository.GrantRepository;
import com.example.aclresource.repository.PartyGrantRepository;
import com.example.aclresource.repository.PartyRepository;
import com.example.aclresource.repository.UserPartyRepository;
import com.example.aclresource.service.PartyService;
import com.example.aclresource.validation.Validator;

import lombok.AllArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DefaultPartyService implements PartyService {
    private PartyRepository partyRepository;
    private GrantRepository grantRepository;
    private PartyGrantRepository partyGrantRepository;
    private UserPartyRepository userPartyRepository;
    private Validator<Party> validator;

    public List<Party> findAll() {
        return partyRepository.findAll();
    }

    public List<Long> findAssignedUserIdList(Long partyId) {
        return userPartyRepository.findByPartyId(partyId).stream()
                .map(UserParty::getUserId)
                .collect(Collectors.toList());
    }

    // TODO: check if it already exists
    public PartyGrant assignGrant(Long partyId, Long grantId) {
        if (!partyRepository.existsById(partyId))
            throw new EntityNotFoundException("a grant cannot be assigned to a non existing party");

        if (!grantRepository.existsById(grantId))
            throw new EntityNotFoundException("a non existing grant cannot be assigned to a party");

        return partyGrantRepository.save(new PartyGrant(null, partyId, grantId));
    }

    public void removeGrant(Long partyId, Long grantId) {
        partyGrantRepository.findByPartyId(partyId).stream()
                .filter(pg -> pg.getGrantId().equals(grantId))
                .findFirst()
                .ifPresent(partyGrantRepository::delete);
    }

    // TODO: check if it already exists
    public UserParty assignUserId(Long partyId, Long userId) {
        if (!partyRepository.existsById(partyId))
            throw new EntityNotFoundException("a user cannot be assigned to a non existing party");

        return userPartyRepository.save(new UserParty(null, userId, partyId));
    }

    public void removeUser(Long partyId, Long userId) {
        userPartyRepository.findByPartyId(partyId).stream()
                .filter(up -> up.getUserId().equals(userId))
                .findFirst()
                .ifPresent(userPartyRepository::delete);
    }

    public Party save(Party party) {
        validator.validate(party);
        return partyRepository.save(party);
    }

    @Override
    @Transactional
    public void deleteById(Long partyId) {
        partyGrantRepository.deleteByPartyId(partyId);
        userPartyRepository.deleteByPartyId(partyId);
        partyRepository.deleteById(partyId);
    }
}
