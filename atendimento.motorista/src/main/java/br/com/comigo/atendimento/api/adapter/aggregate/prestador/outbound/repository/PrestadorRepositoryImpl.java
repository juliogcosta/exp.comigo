package br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.JpaPrestador;
import br.com.comigo.atendimento.api.adapter.util.JpaCnpj;
import br.com.comigo.atendimento.api.adapter.util.JpaEmail;
import br.com.comigo.atendimento.api.adapter.util.JpaEndereco;
import br.com.comigo.atendimento.api.adapter.util.JpaTelefone;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.Prestador;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.repository.PrestadorRepository;
import br.com.comigo.atendimento.api.domain.util.Cnpj;
import br.com.comigo.atendimento.api.domain.util.Telefone;
import br.com.comigo.atendimento.api.mapper.aggregate.prestador.PrestadorMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PrestadorRepositoryImpl implements PrestadorRepository {
    private final JpaPrestadorRepository jpaPrestadorRepository;
    private final PrestadorMapper prestadorMapper;
    
    @Override
    public Prestador create(Prestador prestador) {
        JpaPrestador jpaPrestador = new JpaPrestador(prestador);
        jpaPrestador = this.jpaPrestadorRepository.save(jpaPrestador);
        prestador.setId(jpaPrestador.getId());
        return prestador;
    }

    @Override
    public void update(Prestador prestador) {
        JpaPrestador jpaPrestador = this.jpaPrestadorRepository.findById(prestador.getId())
            .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        jpaPrestador.setCnpj(new JpaCnpj(prestador.getCnpj().value()));
        jpaPrestador.setNome(prestador.getNome());
        jpaPrestador.setEmail(new JpaEmail(prestador.getEmail().value()));
        jpaPrestador.setTelefone(new JpaTelefone(prestador.getTelefone().numero(), prestador.getTelefone().tipo()));
        jpaPrestador.setWhatsapp(new JpaTelefone(prestador.getWhatsapp().numero(), prestador.getWhatsapp().tipo()));
        jpaPrestador.setEndereco(new JpaEndereco(prestador.getEndereco().rua(), prestador.getEndereco().numero(),
            prestador.getEndereco().complemento(), prestador.getEndereco().bairro(), prestador.getEndereco().cidade(),
            prestador.getEndereco().estado(), prestador.getEndereco().cep()));
        jpaPrestador.setStatus(prestador.getStatus());
        this.jpaPrestadorRepository.save(jpaPrestador);
    }

    @Override
    public Optional<Prestador> findById(Long id) {
        Optional<JpaPrestador> optional = this.jpaPrestadorRepository.findById(id);
        return optional.map(prestadorMapper::fromJpaToDomain);
    }
    
    @Override
    public void deleteById(Long id) {
        this.jpaPrestadorRepository.deleteById(id);
    }

    @Override
    public Optional<Prestador> findByCnpj(Cnpj cnpj) {
        Optional<JpaPrestador> optional = this.jpaPrestadorRepository.findByCnpj_Cnpj(cnpj.value());
        return optional.map(prestadorMapper::fromJpaToDomain);
    }

    @Override
    public List<Prestador> findByNome(String nome) {
        return this.jpaPrestadorRepository.findByNome(nome).stream()
            .map(prestadorMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Prestador> findByTelefone(Telefone telefone) {
        return this.jpaPrestadorRepository.findByTelefone_Numero(telefone.numero()).stream()
            .map(prestadorMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }
}