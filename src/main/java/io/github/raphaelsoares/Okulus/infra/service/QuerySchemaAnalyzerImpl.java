package io.github.raphaelsoares.Okulus.infra.service;

import io.github.raphaelsoares.Okulus.domain.model.SqlTemplate;
import io.github.raphaelsoares.Okulus.domain.service.QuerySchemaAnalyzer;
import io.github.raphaelsoares.Okulus.domain.valueobject.ColumnDefinition;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuerySchemaAnalyzerImpl implements QuerySchemaAnalyzer {

    @Override
    public List<ColumnDefinition> extractColumns(SqlTemplate sqlQuery, Id databaseId) {
        return List.of();
    }
}
