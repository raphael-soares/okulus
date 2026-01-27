package io.github.raphaelsoares.Okulus.domain.service;

import io.github.raphaelsoares.Okulus.domain.model.DatabaseType;
import io.github.raphaelsoares.Okulus.domain.model.SqlTemplate;
import io.github.raphaelsoares.Okulus.domain.valueobject.ColumnDefinition;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;

import java.util.List;

public interface QueryIntrospector {
    List<ColumnDefinition> introspectColumns(SqlTemplate template, Id datasourceId);
    DatabaseType getSupportedDatabaseType();
}
