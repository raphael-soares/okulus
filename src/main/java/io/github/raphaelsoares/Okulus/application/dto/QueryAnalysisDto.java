package io.github.raphaelsoares.Okulus.application.dto;

import io.github.raphaelsoares.Okulus.domain.valueobject.ColumnDefinition;

import java.util.List;

public record QueryAnalysisDto(
        List<ColumnDefinition> columns
) {
}
