CREATE TABLE atendimento.setup_de_item_do_servico (
    id BIGSERIAL PRIMARY KEY,
    preco_unitario INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    item_de_servico_id BIGINT NOT NULL,
    prestador_id BIGINT NOT NULL,
    CONSTRAINT fk_setup_prestador FOREIGN KEY (prestador_id) REFERENCES atendimento.prestador (id) ON DELETE CASCADE
);