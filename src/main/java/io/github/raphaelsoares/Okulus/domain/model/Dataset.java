package io.github.raphaelsoares.Okulus.domain.model;

import io.github.raphaelsoares.Okulus.domain.valueobject.ColumnDefinition;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;

import java.util.List;

public class Dataset {

    private Id id;
    private String name;
    private Id databaseId;
    private SqlTemplate sqlTemplate;
    private List<ParameterDefinition> parameters;
    private List<ColumnDefinition> columns;

    protected Dataset() {
    }

    public Dataset(Id id, String name, Id databaseId, SqlTemplate sqlTemplate, List<ParameterDefinition> parameters, List<ColumnDefinition> columns) {
        this.id = id;
        this.name = name;
        this.databaseId = databaseId;
        this.sqlTemplate = sqlTemplate;
        this.parameters = parameters;
        this.columns = columns;
    }

    public boolean canSortByColumn(String columnName) {
        return columns.stream().anyMatch(column -> column.getName().equalsIgnoreCase(columnName));
    }


}
