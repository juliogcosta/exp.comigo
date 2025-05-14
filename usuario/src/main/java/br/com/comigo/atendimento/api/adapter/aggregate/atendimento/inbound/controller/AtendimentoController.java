package br.com.comigo.atendimento.api.adapter.aggregate.atendimento.inbound.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto.AtendimentoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto.ItemDeServicoDoAtendimentoDTO;
import br.com.comigo.atendimento.api.application.aggregate.service.atendimento.AtendimentoServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/atendimento")
public class AtendimentoController {
    private final AtendimentoServiceImpl atendimentoService;

    @PostMapping
    public ResponseEntity<AtendimentoDTO> create(@Valid @RequestBody AtendimentoDTO atendimentoDTO) {
        AtendimentoDTO newAtendimento = this.atendimentoService.create(atendimentoDTO);
        return ResponseEntity.ok(newAtendimento);
    }

    @PutMapping
    public ResponseEntity<AtendimentoDTO> update(@Valid @RequestBody AtendimentoDTO atendimentoDTO) {
        this.atendimentoService.update(atendimentoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoDTO> getServicoDetailsById(@PathVariable Long id) {
        AtendimentoDTO atendimentoDTO = this.atendimentoService.getAtendimentoDetailsById(id);
        return ResponseEntity.ok(atendimentoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletAtendimento(@PathVariable Long id) {
        this.atendimentoService.deleteAtendimento(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/itemDeServicoDoAtendimento")
    public ResponseEntity<Void> addItemDeServicoDoAtendimentoToAtendimento(@PathVariable Long id,
            @RequestBody ItemDeServicoDoAtendimentoDTO itemDeServicoDoAtendimentoDTO) {
        this.atendimentoService.addItemDeServicoDoAtendimentoToAtendimento(itemDeServicoDoAtendimentoDTO, id);
        return ResponseEntity.ok().build();
    }
}
