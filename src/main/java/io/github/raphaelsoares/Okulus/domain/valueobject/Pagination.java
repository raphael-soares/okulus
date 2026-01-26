package io.github.raphaelsoares.Okulus.domain.valueobject;

import io.github.Raphael_Spares.Okulus.domain.exception.InvalidSortingException;

public class Pagination {

    private final int page;
    private final int size;

    public Pagination(int page, int size) {
        if (page < 1) throw InvalidSortingException.invalidPageNumber();
        if (size < 1) throw InvalidSortingException.invalidSizeNumber();
        this.page = page;
        this.size = size;
    }


    public int getOffset() {
        return (page - 1) * size;
    }
}
