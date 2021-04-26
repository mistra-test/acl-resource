package com.example.aclresource.validation;

import javax.validation.ValidationException;

public interface Validator<E> {
    void validate(E entity) throws ValidationException;
}
