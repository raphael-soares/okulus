package io.github.raphaelsoares.Okulus.application.dto;

import io.github.raphaelsoares.Okulus.domain.model.SqlTemplate;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;

public record QueryAnalyzeCommand(
        SqlTemplate sqlTemplate,
        Id datasourceId
) {
}
