package br.com.comigo.atendimento.api.adapter.outbound.repository.domain.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.outbound.aggregate.servico.JpaServico;
import br.com.comigo.atendimento.api.adapter.outbound.repository.jpa.servico.JpaServicoRepository;
import br.com.comigo.atendimento.api.domain.data.aggregate.servico.Servico;
import br.com.comigo.atendimento.api.domain.projection.ServicoItemDeServicoProjection;
import br.com.comigo.atendimento.api.domain.repository.ServicoRepository;
import br.com.comigo.atendimento.api.domain.util.Pagination;
import br.com.comigo.atendimento.api.mapper.ServicoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ServicoRepositoryImpl implements ServicoRepository {
    private final JpaServicoRepository jpaServicoRepository;
    private final ServicoMapper servicoMapper;
    
    @Override
    public Servico save(Servico servico) {
        JpaServico jpaServico = new JpaServico(servico);
        jpaServico = this.jpaServicoRepository.save(jpaServico);
        servico.setId(jpaServico.getId());
        return servico;
    }

    @Override
    public Optional<Servico> findById(Long id) {
        Optional<JpaServico> optional = this.jpaServicoRepository.findById(id);
        return optional.map(servicoMapper::fromJpaToDomain);
    }
    
    @Override
    public List<Servico> findAll() {
        return this.jpaServicoRepository.findAll().stream()
            .map(servicoMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpaServicoRepository.deleteById(id);
    }

    public Pagination<ServicoItemDeServicoProjection> findItemDeServicoByServicoId(@Param("servicoId") String servicoId, int page, int size) {
        Page<ServicoItemDeServicoProjection> springPage 
            = this.jpaServicoRepository.findItemDeServicoByServicoId(servicoId, PageRequest.of(page, size));
        
        return convertToCustomPagination(springPage);
    }

    private <T> Pagination<T> convertToCustomPagination(Page<T> springPage) {
        return new Pagination<>(
            springPage.getContent(),
            springPage.getNumber(),
            springPage.getSize(),
            springPage.getTotalElements()
        );
    }
}