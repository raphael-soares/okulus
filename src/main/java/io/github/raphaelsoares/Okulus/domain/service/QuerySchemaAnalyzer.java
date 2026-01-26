package io.github.raphaelsoares.Okulus.domain.service;

import io.github.raphaelsoares.Okulus.domain.model.SqlTemplate;
import io.github.raphaelsoares.Okulus.domain.valueobject.ColumnDefinition;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;

import java.util.List;

public interface QuerySchemaAnalyzer {

    List<ColumnDefinition> extractColumns(SqlTemplate sqlQuery, Id databaseId);
}
