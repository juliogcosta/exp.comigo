package br.com.comigo.usuario.api.domain.aggregate.atendimento.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import br.com.comigo.usuario.api.domain.aggregate.atendimento.Atendimento;
import br.com.comigo.usuario.api.domain.util.StatusDeAtendimento;

public interface AtendimentoRepository {
    public Atendimento create(Atendimento servico);

    public void update(Atendimento servico);

    public Optional<Atendimento> findById(Long id);

    public Optional<Atendimento> findByVeiculoPlaca(String veiculoPlaca);

    public List<Atendimento> searchByStatus(StatusDeAtendimento status);

    public List<Atendimento> searchByDataHoraConfirmado(Timestamp dataHoraConfirmado);

    public void deleteById(Long id);
}