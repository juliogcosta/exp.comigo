CREATE TABLE usuario.papel_de_usuario (
    id BIGSERIAL PRIMARY KEY,
    status VARCHAR(32),
    usuario_id BIGINT NOT NULL,
    papel_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario.usuario (id) ON DELETE CASCADE,
    FOREIGN KEY (papel_id) REFERENCES usuario.papel (id) ON DELETE CASCADE
);