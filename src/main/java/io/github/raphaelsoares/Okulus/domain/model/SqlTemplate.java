package io.github.raphaelsoares.Okulus.domain.model;

import io.github.raphaelsoares.Okulus.domain.exception.DomainValidationException;
import io.github.Raphael_Spares.Okulus.domain.exception.InvalidSqlException;

public class SqlTemplate {

    private String content;


    protected SqlTemplate() {
    }

    public SqlTemplate(String content) {

        if (content == null || content.isBlank()) {
            throw new DomainValidationException("The contents of the SQL cannot be blank.");
        }

        if (isDangerous(content)) {
            throw new DomainValidationException("The SQL contains potentially dangerous operations (DELETE, DROP, TRUNCATE, UPDATE).");
        }
        this.content = content;
    }


    private boolean isDangerous(String content) {
        String upper = content.toUpperCase();
        return upper.matches(".*\\b(DELETE|DROP|TRUNCATE|UPDATE)\\b.*");
    }


    public String getContent() {
        return content;
    }

}
