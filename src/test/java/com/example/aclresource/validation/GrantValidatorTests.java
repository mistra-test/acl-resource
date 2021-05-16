package com.example.aclresource.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.aclresource.exception.InvalidEntityException;
import com.example.aclresource.model.Grant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GrantValidatorTests {
    @Test
    void validateWithNullName() {
        var grant = new Grant(null, null);

        var validator = new GrantValidator();

        var exception = assertThrows(InvalidEntityException.class, () -> validator.validate(grant));
        var message = exception.getMessage();

        assertEquals("field name of grant cannot be null", message);
    }

    @Test
    void validateWithEmptyName() {
        var grant = new Grant(null, "");

        var validator = new GrantValidator();

        var exception = assertThrows(InvalidEntityException.class, () -> validator.validate(grant));
        var message = exception.getMessage();

        assertEquals("field name of grant cannot be empty", message);
    }
}
