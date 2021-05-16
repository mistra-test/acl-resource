package com.example.aclresource.validation;

import com.example.aclresource.exception.InvalidEntityException;
import com.example.aclresource.model.Grant;

import org.springframework.stereotype.Component;

@Component
public class GrantValidator implements Validator<Grant> {

    @Override
    public void validate(Grant grant) throws InvalidEntityException {
        if (grant.getName() == null)
            throw new InvalidEntityException("field name of grant cannot be null");
        if (grant.getName().isEmpty())
            throw new InvalidEntityException("field name of grant cannot be empty");
    }
}
