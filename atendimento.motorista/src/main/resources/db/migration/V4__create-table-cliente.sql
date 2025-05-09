CREATE TABLE cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone_numero VARCHAR(15),
    telefone_tipo VARCHAR(15),
    whatsapp_numero VARCHAR(15),
    whatsapp_tipo VARCHAR(15),
    email VARCHAR(255),
    endereco_rua VARCHAR(255),
    endereco_numero VARCHAR(10),
    endereco_complemento VARCHAR(255),
    endereco_bairro VARCHAR(255),
    endereco_cidade VARCHAR(255),
    endereco_estado VARCHAR(2),
    endereco_cep VARCHAR(10),
    data_nascimento DATE
);