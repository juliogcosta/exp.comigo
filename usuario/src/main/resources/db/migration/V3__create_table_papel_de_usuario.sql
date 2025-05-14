CREATE TABLE usuario.papel_de_usuario (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    papel_id BIGINT NOT NULL,
    CONSTRAINT fk_papel_de_usuario_usuario FOREIGN KEY (usuario_id) REFERENCES usuario.usuario (id) ON DELETE CASCADE,
    CONSTRAINT fk_papel_de_usuario_papel FOREIGN KEY (papel_id) REFERENCES usuario.papel (id) ON DELETE CASCADE
);