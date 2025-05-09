package br.com.comigo.atendimento.api.adapter.aggregate.cliente.inbound.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.comigo.atendimento.api.adapter.aggregate.cliente.dto.ClienteDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.cliente.dto.VeiculoDTO;
import br.com.comigo.atendimento.api.application.aggregate.service.cliente.ClienteServiceImpl;
import br.com.comigo.atendimento.api.domain.util.Cpf;
import br.com.comigo.atendimento.api.domain.util.Telefone;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteServiceImpl clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO newCliente = this.clienteService.create(clienteDTO);
        return ResponseEntity.ok(newCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteDetailsById(@PathVariable Long id) {
        ClienteDTO clienteDTO = this.clienteService.getClienteDetailsById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClienteDTO> getClienteDetailsByCpf(@PathVariable(name = "cpf") String cpfValue) {
        Cpf cpf = new Cpf(cpfValue);
        ClienteDTO clienteDTO = this.clienteService.getClienteDetailsByCpf(cpf);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ClienteDTO>> getClientesByNome(@PathVariable String nome) {
        List<ClienteDTO> clienteDTOs = this.clienteService.getFilteredClientesByNome(nome);
        return ResponseEntity.ok(clienteDTOs);
    }

    @GetMapping("/telefoneNumero/{telefoneNumero}")
    public ResponseEntity<List<ClienteDTO>> getClientesByTelefone(@PathVariable String telefoneNumero) {
        Telefone telefone = new Telefone(telefoneNumero, null);
        List<ClienteDTO> clienteDTOs = this.clienteService.getFilteredClientesByTelefone(telefone);
        return ResponseEntity.ok(clienteDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        this.clienteService.deleteCliente(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/veiculo")
    public ResponseEntity<Void> addCouponsToEvent(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
        this.clienteService.addVeiculoToCliente(veiculoDTO, id);
        return ResponseEntity.ok().build();
    }
}
