package io.github.raphaelsoares.Okulus.domain.valueobject;

public class ColumnDefinition {
    private final String name;
    private final String dataType;

    public ColumnDefinition(String name, String dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public String getDataType() {
        return dataType;
    }
}
