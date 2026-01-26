package io.github.raphaelsoares.Okulus.domain.model;

import io.github.raphaelsoares.Okulus.domain.exception.DomainValidationException;

public class ParameterDefinition {


    private final String key;
    private final String label;
    private final Boolean required;
    private final String defaultValue;
    private final ParameterType type;


    public ParameterDefinition(String key, String label, Boolean required, String defaultValue, ParameterType type) {

        if (key == null || key.isBlank()) {
            throw new DomainValidationException("The parameter key cannot be null or blank.");
        }

        if (label == null || label.isBlank()) {
            throw new DomainValidationException("The parameter label cannot be null or blank.");
        }

        if (type == null) {
            throw new DomainValidationException("The parameter type cannot be null.");
        }

        this.key = key;
        this.label = label;
        this.required = required;
        this.defaultValue = defaultValue;
        this.type = type;
    }
}
