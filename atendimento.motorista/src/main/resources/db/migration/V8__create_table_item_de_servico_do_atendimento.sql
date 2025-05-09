CREATE TABLE item_de_servico_do_atendimento (
    id BIGSERIAL PRIMARY KEY,
    setup_de_item_de_servico_id BIGINT NOT NULL,
    quantidade INT NOT NULL,
    observacao TEXT,
    atendimento_id BIGINT NOT NULL,
    CONSTRAINT fk_item_de_servico_atendimento FOREIGN KEY (atendimento_id) REFERENCES atendimento (id) ON DELETE CASCADE
);