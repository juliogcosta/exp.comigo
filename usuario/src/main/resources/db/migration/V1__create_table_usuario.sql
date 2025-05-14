CREATE TABLE usuario.usuario (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(32) NOT NULL,
    password VARCHAR(16) NOT NULL,
    nome VARCHAR(256) NOT NULL,
    telefone VARCHAR(12),
    email VARCHAR(256) NOT NULL,
    status VARCHAR(12) NOT NULL
);