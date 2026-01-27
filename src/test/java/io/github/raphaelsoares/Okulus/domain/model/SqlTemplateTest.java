package io.github.raphaelsoares.Okulus.domain.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SqlTemplateTest {

    @Test
    @DisplayName("Deve extrair corretamente os binds (:param) da query")
    void shouldExtractBindParameters() {
        String rawSql = "SELECT * FROM pedidos WHERE cliente_id = :clienteId AND status = :statusPedido";
        SqlTemplate template = new SqlTemplate(rawSql);


        var binds = template.extractParameterNames();

        assertThat(binds)
                .isNotEmpty()
                .hasSize(2)
                .containsExactlyInAnyOrder("clienteId", "statusPedido");
    }

    @Test
    @DisplayName("Não deve confundir :: do Postgres com bind parameters")
    void shouldIgnorePostgresCast() {
        String rawSql = "SELECT valor::numeric FROM pagamentos WHERE id = :id";
        SqlTemplate template = new SqlTemplate(rawSql);

        var binds = template.extractParameterNames();

        assertThat(binds).containsExactly("id");
    }

    @Test
    @DisplayName("Deve gerar versão limpa da query para introspecção (sem ; no final)")
    void shouldCleanQueryForIntrospection() {
        SqlTemplate template = new SqlTemplate("SELECT * FROM dual;  ");

        assertThat(template.getContent().trim()).endsWith(";");
    }
}
