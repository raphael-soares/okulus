package io.github.raphaelsoares.Okulus.infra.jpa;

import io.github.raphaelsoares.Okulus.domain.gateway.DataSourceRepository;
import io.github.raphaelsoares.Okulus.domain.model.DataSource;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataSourceRepositoryImpl implements DataSourceRepository {

    @Override
    public DataSource save(DataSource dataSource) {
        return null;
    }

    @Override
    public Optional<DataSource> findById(Id datasourceId) {
        return Optional.empty();
    }
}
