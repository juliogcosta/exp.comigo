CREATE TABLE atendimento.item_de_servico (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    unidade_medida VARCHAR(50) NOT NULL,
    servico_id BIGINT NOT NULL,
    CONSTRAINT fk_item_de_servico_servico FOREIGN KEY (servico_id) REFERENCES atendimento.servico (id) ON DELETE CASCADE
);