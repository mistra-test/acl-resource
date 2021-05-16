package com.example.aclresource.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.aclresource.exception.InvalidEntityException;
import com.example.aclresource.model.Party;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PartyValidatorTests {
    @Test
    void validateWithNullName() {
        var party = new Party(null, null);

        var validator = new PartyValidator();

        var exception = assertThrows(InvalidEntityException.class, () -> validator.validate(party));
        var message = exception.getMessage();

        assertEquals("field name of party cannot be null", message);
    }

    @Test
    void validateWithEmptyName() {
        var party = new Party(null, "");

        var validator = new PartyValidator();

        var exception = assertThrows(InvalidEntityException.class, () -> validator.validate(party));
        var message = exception.getMessage();

        assertEquals("field name of party cannot be empty", message);
    }
}
