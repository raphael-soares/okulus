package io.github.raphaelsoares.Okulus.infra.jpa;

import io.github.raphaelsoares.Okulus.domain.gateway.DatasetRepository;
import io.github.raphaelsoares.Okulus.domain.model.Dataset;
import org.springframework.stereotype.Service;

@Service
public class DatasetRepositoryImpl implements DatasetRepository {

    @Override
    public Dataset save(Dataset dataset) {
        return null;
    }
}
