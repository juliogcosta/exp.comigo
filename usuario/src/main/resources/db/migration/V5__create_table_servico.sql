CREATE TABLE atendimento.servico (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL
);