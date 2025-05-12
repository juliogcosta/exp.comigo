package br.com.comigo.atendimento.api.adapter.aggregate.prestador.inbound.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto.PrestadorDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto.SetupDeItemDoServicoDTO;
import br.com.comigo.atendimento.api.application.aggregate.service.prestador.PrestadorServiceImpl;
import br.com.comigo.atendimento.api.domain.util.Cnpj;
import br.com.comigo.atendimento.api.domain.util.Telefone;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/prestador")
public class PrestadorController {
    private final PrestadorServiceImpl prestadorService;

    @PostMapping
    public ResponseEntity<PrestadorDTO> create(@Valid @RequestBody PrestadorDTO prestadorDTO) {
        PrestadorDTO newPrestador = this.prestadorService.create(prestadorDTO);
        return ResponseEntity.ok(newPrestador);
    }

    @PutMapping
    public ResponseEntity<PrestadorDTO> update(@Valid @RequestBody PrestadorDTO prestadorDTO) {
        this.prestadorService.update(prestadorDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestadorDTO> getClienteDetailsById(@PathVariable Long id) {
        PrestadorDTO prestadorDTO = this.prestadorService.getPrestadorDetailsById(id);
        return ResponseEntity.ok(prestadorDTO);
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<PrestadorDTO> getPrestadorDetailsByCnpj(@PathVariable(name = "cnpj") String cnpjValue) {
        Cnpj cnpj = new Cnpj(cnpjValue);
        PrestadorDTO prestadorDTO = this.prestadorService.getPrestadorDetailsByCnpj(cnpj);
        return ResponseEntity.ok(prestadorDTO);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<PrestadorDTO>> getPrestadorsByNome(@PathVariable String nome) {
        List<PrestadorDTO> prestadorDTOs = this.prestadorService.getFilteredPrestadorsByNome(nome);
        return ResponseEntity.ok(prestadorDTOs);
    }

    @GetMapping("/telefoneNumero/{telefoneNumero}")
    public ResponseEntity<List<PrestadorDTO>> getClientesByTelefone(@PathVariable String telefoneNumero) {
        Telefone telefone = new Telefone(telefoneNumero, null);
        List<PrestadorDTO> prestadorDTOs = this.prestadorService.getFilteredPrestadorsByTelefone(telefone);
        return ResponseEntity.ok(prestadorDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletPrestador(@PathVariable Long id) {
        this.prestadorService.deletePrestador(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/setupDeItemDoServico")
    public ResponseEntity<Void> addSetupDeItemDoServicoToPrestador(@PathVariable Long id,
            @RequestBody SetupDeItemDoServicoDTO setupDeItemDoServicoDTO) {
        this.prestadorService.addSetupDeItemDoServicoToPrestador(setupDeItemDoServicoDTO, id);
        return ResponseEntity.ok().build();
    }
}
