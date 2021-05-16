package com.example.aclresource.validation;

import com.example.aclresource.exception.InvalidEntityException;
import com.example.aclresource.model.Party;

import org.springframework.stereotype.Component;

@Component
public class PartyValidator implements Validator<Party> {

    @Override
    public void validate(Party party) throws InvalidEntityException {
        if (party.getName() == null)
            throw new InvalidEntityException("field name of party cannot be null");
        if (party.getName().isEmpty())
            throw new InvalidEntityException("field name of party cannot be empty");
    }
}
