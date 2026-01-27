package io.github.raphaelsoares.Okulus.application.usecase;

import io.github.raphaelsoares.Okulus.application.dto.CreateDatasetCommand;
import io.github.raphaelsoares.Okulus.domain.factory.DatasetFactory;
import io.github.raphaelsoares.Okulus.domain.gateway.DatasetRepository;
import io.github.raphaelsoares.Okulus.domain.model.Dataset;
import io.github.raphaelsoares.Okulus.domain.service.QuerySchemaAnalyzer;
import io.github.raphaelsoares.Okulus.domain.valueobject.ColumnDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateDatasetUseCase {

    private final DatasetFactory datasetFactory;
    private final DatasetRepository datasetRepository;
    private final QuerySchemaAnalyzer querySchemaAnalyzer;

    public void execute(CreateDatasetCommand cmd) {
        List<ColumnDefinition> columns = querySchemaAnalyzer.extractColumns(cmd.sqlTemplate(), cmd.datasourceId());
        Dataset dataset = datasetFactory.create(cmd.name(), cmd.sqlTemplate(), cmd.datasourceId(), columns, cmd.parameters());
        datasetRepository.save(dataset);
    }

}
