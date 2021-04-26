package com.example.aclresource.validation;

import javax.validation.ValidationException;

public class InvalidEntityException extends ValidationException {
    public InvalidEntityException(String error) {
        super(error);
    }
}
