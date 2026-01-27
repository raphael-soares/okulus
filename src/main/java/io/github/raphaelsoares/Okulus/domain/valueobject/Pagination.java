package io.github.raphaelsoares.Okulus.domain.valueobject;

import io.github.raphaelsoares.Okulus.domain.exception.DomainValidationException;

public class Pagination {

    private final int page;
    private final int size;

    public Pagination(int page, int size) {
        if (page < 1) throw new DomainValidationException("Page must be greater than zero.");
        if (size < 1) throw new DomainValidationException("Size must be greater than zero.");
        this.page = page;
        this.size = size;
    }


    public int getOffset() {
        return (page - 1) * size;
    }
}
