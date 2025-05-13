package br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound.JpaAtendimento;
import br.com.comigo.atendimento.api.adapter.util.JpaEndereco;
import br.com.comigo.atendimento.api.adapter.util.JpaTelefone;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.Atendimento;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.repository.AtendimentoRepository;
import br.com.comigo.atendimento.api.domain.util.StatusDeAtendimento;
import br.com.comigo.atendimento.api.mapper.aggregate.atendimento.AtendimentoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class AtendimentoRepositoryImpl implements AtendimentoRepository {
  
  private final JpaAtendimentoRepository jpaAtendimentoRepository;
  private final AtendimentoMapper atendimentoMapper;

  @Override
  public Atendimento create(Atendimento servico) {
        JpaAtendimento jpaAtendimento = new JpaAtendimento(servico);
        jpaAtendimento = this.jpaAtendimentoRepository.save(jpaAtendimento);
        servico.setId(jpaAtendimento.getId());
        return servico;
  }

  @Override
  public void update(Atendimento atendimento) {
    JpaAtendimento jpaAtendimento = this.jpaAtendimentoRepository.findById(atendimento.getId())
        .orElseThrow(() -> new IllegalArgumentException("Atendimento não encontrado"));
    jpaAtendimento.setId(atendimento.getId());
    jpaAtendimento.setPrestadorId(atendimento.getPrestadorId());
    jpaAtendimento.setClienteId(atendimento.getClienteId());
    jpaAtendimento.setClienteNome(atendimento.getClienteNome());
    jpaAtendimento.setClienteTelefone(new JpaTelefone(atendimento.getClienteTelefone().numero(), atendimento.getClienteTelefone().tipo()));
    jpaAtendimento.setClienteWhatsapp(new JpaTelefone(atendimento.getClienteWhatsapp().numero(), atendimento.getClienteWhatsapp().tipo()));
    jpaAtendimento.setVeiculoId(atendimento.getVeiculoId());
    jpaAtendimento.setVeiculoPlaca(atendimento.getVeiculoPlaca());
    jpaAtendimento.setTipoOcorrencia(atendimento.getTipoOcorrencia());
    jpaAtendimento.setTipoServico(atendimento.getTipoServico());
    jpaAtendimento.setStatus(atendimento.getStatus());
    jpaAtendimento.setDataHoraChamado(atendimento.getDataHoraChamado());
    jpaAtendimento.setDataHoraConfirmado(atendimento.getDataHoraConfirmado());
    jpaAtendimento.setDataHoraEmAndamento(atendimento.getDataHoraEmAndamento());
    jpaAtendimento.setDataHoraFinalizado(atendimento.getDataHoraFinalizado());
    jpaAtendimento.setDataHoraCancelado(atendimento.getDataHoraCancelado());
    jpaAtendimento.setDescricao(atendimento.getDescricao());
    jpaAtendimento.setBase(new JpaEndereco(
      atendimento.getBase().logradouro(),
      atendimento.getBase().numero(),
      atendimento.getBase().complemento(),
      atendimento.getBase().bairro(),
      atendimento.getBase().cidade(),
      atendimento.getBase().estado(),
      atendimento.getBase().cep()));
    jpaAtendimento.setOrigem(new JpaEndereco(
        atendimento.getOrigem().logradouro(),
        atendimento.getOrigem().numero(),
        atendimento.getOrigem().complemento(),
        atendimento.getOrigem().bairro(),
        atendimento.getOrigem().cidade(),
        atendimento.getOrigem().estado(),
        atendimento.getOrigem().cep()));
    jpaAtendimento.setDestino(new JpaEndereco(
      atendimento.getDestino().logradouro(),
      atendimento.getDestino().numero(),
      atendimento.getDestino().complemento(),
      atendimento.getDestino().bairro(),
      atendimento.getDestino().cidade(),
      atendimento.getDestino().estado(),
      atendimento.getDestino().cep()));
    this.jpaAtendimentoRepository.save(jpaAtendimento);
  }

  @Override
  public Optional<Atendimento> findById(Long id) {
    Optional<JpaAtendimento> optional = this.jpaAtendimentoRepository.findById(id);
    return optional.map(atendimentoMapper::fromJpaToDomain);
  }

  @Override
  public Optional<Atendimento> findByVeiculoPlaca(String veiculoPlaca) {
    Optional<JpaAtendimento> optional = this.jpaAtendimentoRepository.findByVeiculoPlaca(veiculoPlaca);
    return optional.map(atendimentoMapper::fromJpaToDomain);
  }

  @Override
  public List<Atendimento> searchByStatus(StatusDeAtendimento status) {
        return this.jpaAtendimentoRepository.findByStatus(status.name()).stream()
            .map(atendimentoMapper::fromJpaToDomain)
            .collect(Collectors.toList());
  }

  @Override
  public List<Atendimento> searchByDataHoraConfirmado(Timestamp dataHoraConfirmado) {
    return this.jpaAtendimentoRepository.findByDataHoraConfirmado(dataHoraConfirmado).stream()
        .map(atendimentoMapper::fromJpaToDomain)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteById(Long id) {
    this.jpaAtendimentoRepository.deleteById(id);
  }

}