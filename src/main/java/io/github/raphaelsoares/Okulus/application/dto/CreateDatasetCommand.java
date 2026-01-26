package io.github.raphaelsoares.Okulus.application.dto;

import io.github.raphaelsoares.Okulus.domain.model.ParameterDefinition;
import io.github.raphaelsoares.Okulus.domain.model.SqlTemplate;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;

import java.util.List;

public record CreateDatasetCommand(
        String name,
        SqlTemplate sqlTemplate,
        List<ColumnDefinitionDto> columns,
        List<ParameterDefinition> parameters,
        Id datasourceId
) {
}
