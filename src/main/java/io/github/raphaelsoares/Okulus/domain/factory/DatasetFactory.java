package io.github.raphaelsoares.Okulus.domain.factory;

import io.github.raphaelsoares.Okulus.application.dto.ColumnDefinitionDto;
import io.github.raphaelsoares.Okulus.domain.model.Dataset;
import io.github.raphaelsoares.Okulus.domain.model.ParameterDefinition;
import io.github.raphaelsoares.Okulus.domain.model.SqlTemplate;
import io.github.raphaelsoares.Okulus.domain.service.QuerySchemaAnalyzer;
import io.github.raphaelsoares.Okulus.domain.valueobject.ColumnDefinition;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DatasetFactory {


    private final QuerySchemaAnalyzer querySchemaAnalyzer;


    public static Dataset create(String name, SqlTemplate template, Id databaseId, List<ColumnDefinition> columns, List<ParameterDefinition> parameters) {
        return new Dataset(null, name, databaseId, template, parameters, columns);
    }
}
