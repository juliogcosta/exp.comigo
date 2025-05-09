package br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClienteRepository extends JpaRepository<JpaCliente, Long> {
    public void update(JpaCliente jpaCliente); 

    public Optional<JpaCliente> findByCpf_Cpf(String cpf);

    public List<JpaCliente> findByNome(String nome);

    public List<JpaCliente> findByTelefone_Numero(String numero);
}