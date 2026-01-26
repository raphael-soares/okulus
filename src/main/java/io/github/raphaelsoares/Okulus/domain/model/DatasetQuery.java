package io.github.raphaelsoares.Okulus.domain.model;

import io.github.raphaelsoares.Okulus.domain.valueobject.Id;
import io.github.raphaelsoares.Okulus.domain.valueobject.Pagination;
import io.github.raphaelsoares.Okulus.domain.valueobject.Sorting;

import java.util.Map;

public class DatasetQuery {

    private final Id datasetId;
    private final Map<String, Object> parameterValues;
    private final Pagination pagination;
    private final Sorting sorting;

    public DatasetQuery(Id datasetId, Map<String, Object> parameterValues, Pagination pagination, Sorting sorting) {
        this.datasetId = datasetId;
        this.parameterValues = parameterValues;
        this.pagination = pagination;
        this.sorting = sorting;
    }

    public Id getDatasetId() {
        return datasetId;
    }

    public Map<String, Object> getParameterValues() {
        return parameterValues;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public Sorting getSorting() {
        return sorting;
    }
}
