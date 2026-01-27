package io.github.raphaelsoares.Okulus.infra.service;

import io.github.raphaelsoares.Okulus.domain.exception.ResourceNotFoundException;
import io.github.raphaelsoares.Okulus.domain.gateway.DataSourceRepository;
import io.github.raphaelsoares.Okulus.domain.model.DataSource;
import io.github.raphaelsoares.Okulus.domain.model.DatabaseType;
import io.github.raphaelsoares.Okulus.domain.model.SqlTemplate;
import io.github.raphaelsoares.Okulus.domain.service.QueryIntrospector;
import io.github.raphaelsoares.Okulus.domain.valueobject.ColumnDefinition;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OracleQueryIntrospector implements QueryIntrospector {


    private final DataSourceRepository dataSourceRepository;

    private static @NonNull List<ColumnDefinition> getColumnDefinitions(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.getResultSet();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<ColumnDefinition> columns = new ArrayList<>();

        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            String columnType = metaData.getColumnTypeName(i);

            ColumnDefinition columnDefinition = new ColumnDefinition(columnName, columnType);
            columns.add(columnDefinition);
        }
        return columns;
    }

    @Override
    public List<ColumnDefinition> introspectColumns(SqlTemplate template, Id datasourceId) {
        String safeQuery = "SELECT * FROM ( " + template.getContentWithoutTrailingSemicolon() + " ) as wrapper where " + "1=0;";
        DataSource dataSource = dataSourceRepository.findById(datasourceId).orElseThrow(() -> new ResourceNotFoundException("Data source", datasourceId));

        try {
            Connection connection = DriverManager.getConnection(dataSource.getConnectionString(), dataSource.getUsername(), dataSource.getPassword());
            PreparedStatement statement = connection.prepareStatement(safeQuery);
            return getColumnDefinitions(statement);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to Oracle database", e);
        }
    }

    @Override
    public DatabaseType getSupportedDatabaseType() {
        return DatabaseType.ORACLE;
    }
}
