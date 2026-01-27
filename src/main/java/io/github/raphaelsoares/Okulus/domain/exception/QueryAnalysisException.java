package io.github.raphaelsoares.Okulus.domain.exception;

public abstract class QueryAnalysisException extends RuntimeException {

    protected QueryAnalysisException(String message) {
        super(message);
    }

    protected QueryAnalysisException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class BadSqlGrammar extends QueryAnalysisException {
        public BadSqlGrammar(String sql, String dbError) {
            super("Erro de sintaxe SQL: " + dbError + " [SQL: " + sql + "]");
        }
    }

    public static class ConnectionFailed extends QueryAnalysisException {
        public ConnectionFailed(String dbName, Throwable cause) {
            super("Não foi possível conectar ao banco " + dbName, cause);
        }
    }

    public static class DataTypeNotSupported extends QueryAnalysisException {
        public DataTypeNotSupported(String typeName) {
            super("O tipo de dado " + typeName + " não é suportado pelo Okulus.");
        }
    }
}
