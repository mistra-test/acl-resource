package com.example.aclresource.exception;

import javax.validation.ValidationException;

public class InvalidEntityException extends ValidationException {
    public InvalidEntityException(String error) {
        super(error);
    }
}
