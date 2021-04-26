package com.example.aclresource.validation;

import com.example.aclresource.model.Grant;

public class GrantValidator implements Validator<Grant> {

    @Override
    public void validate(Grant grant) throws InvalidEntityException {

        if (grant.getName() == null) {
            throw new InvalidEntityException("Field name cannot be null");
        }
    }
}
