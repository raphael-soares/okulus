package io.github.raphaelsoares.Okulus.domain.gateway;

import io.github.raphaelsoares.Okulus.domain.model.DataSource;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;

import java.util.Optional;

public interface DataSourceRepository {


    DataSource save(DataSource dataSource);

    Optional<DataSource> findById(Id datasourceId);
}
