package io.github.raphaelsoares.Okulus.domain.valueobject;

import io.github.raphaelsoares.Okulus.domain.exception.DomainValidationException;

public class Sorting {
    private final String column;
    private final SortDirection direction;

    public Sorting(String column, SortDirection direction) {
        if (column == null || column.isBlank())
            throw new DomainValidationException("Coluna de ordenação obrigatória");
        this.column = column;
        this.direction = direction != null ? direction : SortDirection.ASC;
    }

    public String getColumn() {
        return column;
    }

    public SortDirection getDirection() {
        return direction;
    }
}
