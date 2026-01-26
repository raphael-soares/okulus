package io.github.raphaelsoares.Okulus.domain.gateway;

import io.github.raphaelsoares.Okulus.domain.model.DataSource;

public interface DataSourceRepository {


    DataSource save(DataSource dataSource);
}
