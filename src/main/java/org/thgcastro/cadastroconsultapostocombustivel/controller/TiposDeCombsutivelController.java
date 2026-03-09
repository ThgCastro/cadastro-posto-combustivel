package org.thgcastro.cadastroconsultapostocombustivel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.TiposDeCombustivel;
import org.thgcastro.cadastroconsultapostocombustivel.service.TiposDeCombustivelService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tiposCombustivel")
public class TiposDeCombsutivelController {

    private final TiposDeCombustivelService tiposDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelService.criar(tiposDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<TiposDeCombustivel>> buscarTiposDeCombsutivel(){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiposDeCombustivel> buscarTiposDeCombsutivelPorId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivelPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTiposDeCombustivel(@PathVariable(name = "id") Integer id){
        tiposDeCombustivelService.deletarTiposDeCombustivelPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarTiposDeCombustivel(@RequestParam(name = "id") Integer id, @RequestBody TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelService.atualizarTiposDeCombustivel(id, tiposDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
