package io.github.raphaelsoares.Okulus.application.dto;

import io.github.raphaelsoares.Okulus.domain.model.DatabaseType;

public record CreateDatabaseCommand(
        DatabaseType type,
        String name,
        String host,
        Integer port,
        String databaseName,
        String username,
        String password

) {
}
