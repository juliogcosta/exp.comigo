package br.com.comigo.usuario.api.adapter.aggregate.prestador.dto;

import java.util.List;

import br.com.comigo.usuario.api.domain.util.Cnpj;
import br.com.comigo.usuario.api.domain.util.Email;
import br.com.comigo.usuario.api.domain.util.Endereco;
import br.com.comigo.usuario.api.domain.util.StatusDePrestador;
import br.com.comigo.usuario.api.domain.util.Telefone;

public record PrestadorDTO(
        Long id,
        String nome,
        Cnpj cnpj,
        Telefone telefone,
        Telefone whatsapp,
        Email email,
        Endereco endereco,
        StatusDePrestador status,
        List<SetupDeItemDoServicoDTO> setupDeItemDoServicos) {
}