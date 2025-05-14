package br.com.comigo.usuario.api.adapter.aggregate.cliente.outbound.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.usuario.api.adapter.aggregate.cliente.outbound.JpaCliente;
import br.com.comigo.usuario.api.adapter.aggregate.cliente.outbound.JpaVeiculo;
import br.com.comigo.usuario.api.domain.aggregate.cliente.Veiculo;
import br.com.comigo.usuario.api.domain.aggregate.cliente.repository.VeiculoRepository;
import br.com.comigo.usuario.api.mapper.aggregate.cliente.ClienteMapper;
import br.com.comigo.usuario.api.mapper.aggregate.cliente.VeiculoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class VeiculoRepositoryImpl implements VeiculoRepository {
    private final JpaClienteRepository jpaClienteRepository;
    private final ClienteMapper clienteMapper;
    private final JpaVeiculoRepository jpaVeiculoRepository;
    private final VeiculoMapper veiculoMapper;
    
    @Override
    public void create(Veiculo veiculo, Long clienteId) {
        JpaCliente jpaCliente = this.jpaClienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        veiculo.setCliente(this.clienteMapper.fromJpaToDomain(jpaCliente));

        JpaVeiculo jpaVeiculo = new JpaVeiculo();
        jpaVeiculo.setMarca(veiculo.getMarca());
        jpaVeiculo.setModelo(veiculo.getModelo());
        jpaVeiculo.setPlaca(veiculo.getPlaca());
        jpaVeiculo.setCor(veiculo.getCor());
        jpaVeiculo.setAno(veiculo.getAno());

        jpaCliente.getVeiculos().add(jpaVeiculo);

        this.jpaClienteRepository.save(jpaCliente);
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