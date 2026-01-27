package io.github.raphaelsoares.Okulus.domain.exception;


import io.github.raphaelsoares.Okulus.domain.valueobject.Id;

public class ResourceNotFoundException extends OkulusException {

    public ResourceNotFoundException(String resourceName, Id id) {
        super(String.format("%s not found with id: %s", resourceName, id.toString()));
    }

    public ResourceNotFoundException(String resourceName, String field, String value) {
        super(String.format("%s not found with %s: %s", resourceName, field, value));
    }
}
