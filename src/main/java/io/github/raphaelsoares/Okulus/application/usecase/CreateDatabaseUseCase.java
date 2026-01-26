package io.github.raphaelsoares.Okulus.application.usecase;

import io.github.raphaelsoares.Okulus.application.dto.CreateDatabaseCommand;
import io.github.raphaelsoares.Okulus.domain.gateway.DataSourceRepository;
import io.github.raphaelsoares.Okulus.domain.model.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateDatabaseUseCase {

    private final DataSourceRepository dataSourceRepository;

    public void execute(CreateDatabaseCommand cmd) {
        DataSource dataSource = new DataSource(cmd.name(), cmd.databaseName(), cmd.host(), cmd.port(), cmd.username(), cmd.password(), null);
        dataSourceRepository.save(dataSource);
    }
}
