package com.example.aclresource.validation;

import com.example.aclresource.exception.InvalidEntityException;

public interface Validator<E> {
    void validate(E entity) throws InvalidEntityException;
}
