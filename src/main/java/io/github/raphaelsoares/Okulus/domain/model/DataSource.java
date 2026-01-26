package io.github.raphaelsoares.Okulus.domain.model;

import io.github.raphaelsoares.Okulus.domain.exception.DomainValidationException;
import io.github.raphaelsoares.Okulus.domain.valueobject.Id;

public class DataSource {

    private String name;
    private String databaseName;
    private String host;
    private int port;
    private String username;
    private String password;
    private Id id;
    private DatabaseType type;


    public DataSource(String name, String database, String host, int port, String username, String password, Id id) {

        if (name == null || name.isEmpty()) {
            throw new DomainValidationException("DataSource name cannot be null or empty");
        }


        this.name = name;
        this.databaseName = database;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getConnectionString() {
        return "jdbc:" + type + "://" + host + ":" + port + "/" + databaseName;

    }


    public String getName() {
        return name;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Id getId() {
        return id;
    }

    public DatabaseType getType() {
        return type;
    }
}
