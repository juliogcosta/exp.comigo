package br.com.comigo.usuario.adapter.aggregate.papel.inbound.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.comigo.usuario.adapter.aggregate.papel.dto.PapelDTO;
import br.com.comigo.usuario.application.aggregate.service.papel.PapelServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/papel")
public class PapelController {
    private final PapelServiceImpl papelService;

    @PostMapping
    public ResponseEntity<PapelDTO> create(@Valid @RequestBody PapelDTO papelDTO) {
        PapelDTO newPapel = this.papelService.create(papelDTO);
        return ResponseEntity.ok(newPapel);
    }

    @PutMapping
    public ResponseEntity<PapelDTO> update(@Valid @RequestBody PapelDTO papelDTO) {
        this.papelService.update(papelDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PapelDTO> getClienteDetailsById(@PathVariable Long id) {
        PapelDTO papelDTO = this.papelService.getPapelDetailsById(id);
        return ResponseEntity.ok(papelDTO);
    }

    @GetMapping
    public ResponseEntity<List<PapelDTO>> getAllClientes(@PathVariable Long id) {
        List<PapelDTO> papelDTOs = this.papelService.getAll();
        return ResponseEntity.ok(papelDTOs);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<PapelDTO> getPapelDetailsByCnpj(String nome) {
        PapelDTO papelDTO = this.papelService.getPapelDetailsByNome(nome);
        return ResponseEntity.ok(papelDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletPapel(@PathVariable Long id) {
        this.papelService.deletePapel(id);
        return ResponseEntity.ok().build();
    }
}
