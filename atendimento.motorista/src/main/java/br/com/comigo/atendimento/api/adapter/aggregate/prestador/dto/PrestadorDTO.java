package br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto;

import java.util.List;

import br.com.comigo.atendimento.api.domain.util.StatusDePrestador;
import br.com.comigo.common.model.utils.Cnpj;
import br.com.comigo.common.model.utils.Email;
import br.com.comigo.common.model.utils.Endereco;
import br.com.comigo.common.model.utils.Telefone;

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