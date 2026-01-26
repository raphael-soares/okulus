package io.github.raphaelsoares.Okulus.domain.gateway;

import io.github.raphaelsoares.Okulus.domain.model.Dataset;

public interface DatasetRepository {


    Dataset save(Dataset dataset);
}
