CREATE TABLE veiculo (
    id BIGSERIAL PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    cor VARCHAR(50) NULL,
    placa VARCHAR(20) NOT NULL UNIQUE,
    ano VARCHAR(4) NULL,
    cliente_id BIGINT NOT NULL,
    CONSTRAINT fk_veiculo_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id) ON DELETE CASCADE
);