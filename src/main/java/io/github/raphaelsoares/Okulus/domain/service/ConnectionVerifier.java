package io.github.raphaelsoares.Okulus.domain.service;


public interface ConnectionVerifier {

    void verifyConnection(String connectionString, String username, String password);

}
