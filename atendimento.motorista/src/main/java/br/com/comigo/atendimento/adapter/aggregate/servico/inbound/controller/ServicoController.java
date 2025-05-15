package br.com.comigo.atendimento.adapter.aggregate.servico.inbound.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.comigo.atendimento.adapter.aggregate.servico.dto.ItemDeServicoDTO;
import br.com.comigo.atendimento.adapter.aggregate.servico.dto.ServicoDTO;
import br.com.comigo.atendimento.application.aggregate.service.servico.ServicoServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/servico")
public class ServicoController {
    private final ServicoServiceImpl servicoService;

    @PostMapping
    public ResponseEntity<ServicoDTO> create(@Valid @RequestBody ServicoDTO servicoDTO) {
        ServicoDTO newServico = this.servicoService.create(servicoDTO);
        return ResponseEntity.ok(newServico);
    }

    @PutMapping
    public ResponseEntity<ServicoDTO> update(@Valid @RequestBody ServicoDTO prestadorDTO) {
        this.servicoService.update(prestadorDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> getServicoDetailsById(@PathVariable Long id) {
        ServicoDTO servicoDTO = this.servicoService.getServicoDetailsById(id);
        return ResponseEntity.ok(servicoDTO);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<ServicoDTO> getServicosByNome(@PathVariable String nome) {
        ServicoDTO servicoDTO = this.servicoService.getServicoDetailsByNome(nome);
        return ResponseEntity.ok(servicoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletServico(@PathVariable Long id) {
        this.servicoService.deleteServico(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/itemDeServico")
    public ResponseEntity<Void> addItemDeServicoToServico(@PathVariable Long id,
            @RequestBody ItemDeServicoDTO itemDeServicoDTO) {
        this.servicoService.addItemDeServicoToServico(itemDeServicoDTO, id);
        return ResponseEntity.ok().build();
    }
}
