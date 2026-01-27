package io.github.raphaelsoares.Okulus.application.usecase;

import io.github.raphaelsoares.Okulus.application.dto.QueryAnalysisDto;
import io.github.raphaelsoares.Okulus.application.dto.QueryAnalyzeCommand;
import io.github.raphaelsoares.Okulus.domain.service.QuerySchemaAnalyzer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryAnalyzeUseCase {

    private final QuerySchemaAnalyzer querySchemaAnalyzer;


    public QueryAnalysisDto excecute(QueryAnalyzeCommand cmd) {
        var columns = querySchemaAnalyzer.extractColumns(cmd.sqlTemplate(), cmd.datasourceId());
        return new QueryAnalysisDto(columns);
    }
}
