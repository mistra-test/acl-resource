package com.example.aclresource.exception;

public class InvalidEntityException extends RuntimeException {
    public InvalidEntityException(String error) {
        super(error);
    }
}
