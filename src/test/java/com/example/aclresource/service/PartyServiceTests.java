package com.example.aclresource.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.aclresource.exception.EntityNotFoundException;
import com.example.aclresource.exception.InvalidEntityException;
import com.example.aclresource.model.Party;
import com.example.aclresource.model.PartyGrant;
import com.example.aclresource.model.UserParty;
import com.example.aclresource.repository.GrantRepository;
import com.example.aclresource.repository.PartyGrantRepository;
import com.example.aclresource.repository.PartyRepository;
import com.example.aclresource.repository.UserPartyRepository;
import com.example.aclresource.service.impl.DefaultPartyService;
import com.example.aclresource.validation.Validator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

class DummyPartyValidator implements Validator<Party> {

    @Override
    public void validate(Party entity) throws InvalidEntityException {
        // do nothing
    }
}

@SpringBootTest
class PartyServiceTests {

    private PartyService partyService;

    private PartyRepository partyRepository;
    private GrantRepository grantRepository;
    private PartyGrantRepository partyGrantRepository;
    private UserPartyRepository userPartyRepository;

    public PartyServiceTests() {
        partyRepository = Mockito.mock(PartyRepository.class);
        grantRepository = Mockito.mock(GrantRepository.class);
        partyGrantRepository = Mockito.mock(PartyGrantRepository.class);
        userPartyRepository = Mockito.mock(UserPartyRepository.class);
        var dummyValidator = new DummyPartyValidator();

        partyService =
                new DefaultPartyService(
                        partyRepository,
                        grantRepository,
                        partyGrantRepository,
                        userPartyRepository,
                        dummyValidator);
    }

    @Test
    void findAll() {
        final Party party1 = new Party(1L, "ADMIN");
        final Party party2 = new Party(2L, "USER");

        final var result = Arrays.asList(party1, party2);
        Mockito.when(partyRepository.findAll()).thenReturn(result);

        assertEquals(result, partyService.findAll());
    }

    @Test
    void findAssignedUserIdList() {

        final var userParty1 = new UserParty(1L, 1L, 1L);
        final var userParty2 = new UserParty(2L, 2L, 1L);

        final var userPartyList = Arrays.asList(userParty1, userParty2);
        Mockito.when(userPartyRepository.findByPartyId(1L)).thenReturn(userPartyList);

        final var result = Arrays.asList(1L, 2L);

        assertEquals(result, partyService.findAssignedUserIdList(1L));
    }

    @Test
    void assignGrant() {

        var partyGrant = new PartyGrant(null, 1L, 2L);

        Mockito.when(partyRepository.existsById(1L)).thenReturn(true);
        Mockito.when(grantRepository.existsById(2L)).thenReturn(true);

        final var result = new PartyGrant(1L, 1L, 2L);
        Mockito.when(partyGrantRepository.save(partyGrant)).thenReturn(result);

        assertEquals(result, partyService.assignGrant(1L, 2L));
    }

    @Test
    void assignGrantToMissingParty() {

        var partyGrant = new PartyGrant(null, 1L, 2L);

        Mockito.when(partyRepository.existsById(1L)).thenReturn(false);
        Mockito.when(grantRepository.existsById(2L)).thenReturn(true);

        final var result = new PartyGrant(1L, 1L, 2L);
        Mockito.when(partyGrantRepository.save(partyGrant)).thenReturn(result);

        assertThrows(EntityNotFoundException.class, () -> partyService.assignGrant(1L, 2L));
    }

    @Test
    void assignGrantWithMissingGrant() {

        var partyGrant = new PartyGrant(null, 1L, 2L);

        Mockito.when(partyRepository.existsById(1L)).thenReturn(true);
        Mockito.when(grantRepository.existsById(2L)).thenReturn(false);

        final var result = new PartyGrant(1L, 1L, 2L);
        Mockito.when(partyGrantRepository.save(partyGrant)).thenReturn(result);

        assertThrows(EntityNotFoundException.class, () -> partyService.assignGrant(1L, 2L));
    }

    @Test
    void removeGrant() {

        var partyGrant1 = new PartyGrant(1L, 1L, 2L);
        var partyGrant2 = new PartyGrant(1L, 1L, 3L);
        var partyGrant3 = new PartyGrant(1L, 2L, 3L);

        var partyGrantList = Arrays.asList(partyGrant1, partyGrant2, partyGrant3);

        Mockito.when(partyGrantRepository.findByPartyId(1L)).thenReturn(partyGrantList);

        final var result = new PartyGrant(1L, 1L, 2L);
        partyService.removeGrant(1L, 2L);
        Mockito.verify(partyGrantRepository).delete(result);
    }

    @Test
    void assignUserId() {

        var userParty = new UserParty(null, 1L, 1L);

        Mockito.when(partyRepository.existsById(1L)).thenReturn(true);

        final var result = new UserParty(1L, 1L, 1L);
        Mockito.when(userPartyRepository.save(userParty)).thenReturn(result);

        assertEquals(result, partyService.assignUserId(1L, 1L));
    }

    @Test
    void assignUserIdToMissingParty() {

        var userParty = new UserParty(null, 1L, 1L);

        Mockito.when(partyRepository.existsById(1L)).thenReturn(false);

        final var result = new UserParty(1L, 1L, 1L);
        Mockito.when(userPartyRepository.save(userParty)).thenReturn(result);

        assertThrows(EntityNotFoundException.class, () -> partyService.assignUserId(1L, 1L));
    }

    @Test
    void removeUser() {

        var userParty1 = new UserParty(1L, 2L, 1L);
        var userParty2 = new UserParty(1L, 3L, 1L);
        var userParty3 = new UserParty(1L, 3L, 2L);

        var userPartyList = Arrays.asList(userParty1, userParty2, userParty3);

        Mockito.when(userPartyRepository.findByPartyId(1L)).thenReturn(userPartyList);

        final var result = new UserParty(1L, 2L, 1L);
        partyService.removeUser(1L, 2L);
        Mockito.verify(userPartyRepository).delete(result);
    }

    @Test
    void saveParty() {

        final var party = new Party("ADMIN");
        final var result = new Party(1L, "ADMIN");

        Mockito.when(partyRepository.save(party)).thenReturn(result);

        assertEquals(result, partyService.save(party));
    }

    @Test
    void deletePartyById() {

        partyService.deleteById(1L);

        Mockito.verify(partyRepository).deleteById(1L);
        Mockito.verify(partyGrantRepository).deleteByPartyId(1L);
        Mockito.verify(userPartyRepository).deleteByPartyId(1L);
    }
}
