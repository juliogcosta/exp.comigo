package br.com.comigo.atendimento.api.adapter.outbound.repository.domain.cliente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.outbound.aggregate.cliente.JpaVeiculo;
import br.com.comigo.atendimento.api.adapter.outbound.repository.jpa.cliente.JpaVeiculoRepository;
import br.com.comigo.atendimento.api.domain.data.aggregate.cliente.Veiculo;
import br.com.comigo.atendimento.api.domain.repository.VeiculoRepository;
import br.com.comigo.atendimento.api.mapper.VeiculoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class VeiculoRepositoryImpl implements VeiculoRepository {
    private final JpaVeiculoRepository jpaVeiculoRepository;
    private final VeiculoMapper veiculoMapper;
    
    @Override
    public Veiculo create(Veiculo veiculo) {
        JpaVeiculo jpaVeiculo = new JpaVeiculo(veiculo);
        jpaVeiculo = this.jpaVeiculoRepository.save(jpaVeiculo);
        veiculo.setId(jpaVeiculo.getId());
        return veiculo;
    }

    @Override
    public Optional<Veiculo> findById(Long id) {
        Optional<JpaVeiculo> optional = this.jpaVeiculoRepository.findById(id);
        return optional.map(veiculoMapper::fromJpaToDomain);
    }
    
    @Override
    public List<Veiculo> findAll() {
        return this.jpaVeiculoRepository.findAll().stream()
            .map(veiculoMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpaVeiculoRepository.deleteById(id);
    }
}