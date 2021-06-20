package com.example.aclresource.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.aclresource.exception.InvalidEntityException;
import com.example.aclresource.model.Grant;
import com.example.aclresource.model.PartyGrant;
import com.example.aclresource.repository.GrantRepository;
import com.example.aclresource.repository.PartyGrantRepository;
import com.example.aclresource.service.impl.DefaultGrantService;
import com.example.aclresource.validation.Validator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

class DummyGrantValidator implements Validator<Grant> {

    @Override
    public void validate(Grant grant) throws InvalidEntityException {
        // do nothing
    }
}

@SpringBootTest
class GrantServiceTests {

    private GrantService grantService;

    private GrantRepository grantRepository;
    private PartyGrantRepository partyGrantRepository;

    public GrantServiceTests() {
        grantRepository = Mockito.mock(GrantRepository.class);
        partyGrantRepository = Mockito.mock(PartyGrantRepository.class);
        var dummyValidator = new DummyGrantValidator();

        grantService =
                new DefaultGrantService(grantRepository, partyGrantRepository, dummyValidator);
    }

    @Test
    void findByPartyId() {

        final var grant1 = new Grant(1L, "movie_read");
        final var grant2 = new Grant(2L, "movie_write");

        final var partyGrant1 = new PartyGrant(1L, 1L, 1L);
        final var partyGrant2 = new PartyGrant(2L, 1L, 2L);

        final var partyGrantList = Arrays.asList(partyGrant1, partyGrant2);
        Mockito.when(partyGrantRepository.findByPartyId(1L)).thenReturn(partyGrantList);

        Mockito.when(grantRepository.findById(1L)).thenReturn(Optional.of(grant1));
        Mockito.when(grantRepository.findById(2L)).thenReturn(Optional.of(grant2));

        final var result = Arrays.asList(grant1, grant2);

        assertEquals(result, grantService.findByPartyId(1L));
    }
}
