package br.com.comigo.atendimento.api.application.usecase.prestador;

import java.util.List;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto.PrestadorDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto.SetupDeItemDoServicoDTO;
import br.com.comigo.common.model.utils.Cnpj;
import br.com.comigo.common.model.utils.Telefone;

public interface PrestadorUseCases {
    public PrestadorDTO create(PrestadorDTO dto);

    public void update(PrestadorDTO dto);

    public PrestadorDTO getPrestadorDetailsById(Long id);

    public PrestadorDTO getPrestadorDetailsByCnpj(Cnpj cnpj);

    public List<PrestadorDTO> getFilteredPrestadorsByNome(String nome);

    public List<PrestadorDTO> getFilteredPrestadorsByTelefone(Telefone telefone);

    public void deletePrestador(Long id);

    public void addSetupDeItemDoServicoToPrestador(SetupDeItemDoServicoDTO setupDeItemDoServicoDTO, Long prestadorId);

    public void deleteSetupDeItemDoServico(Long id);
}