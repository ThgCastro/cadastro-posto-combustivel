package org.thgcastro.cadastroconsultapostocombustivel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.BombasDeCombustivel;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.TiposDeCombustivel;
import org.thgcastro.cadastroconsultapostocombustivel.service.BombasDeCombustivelService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bombasDeCombustivel")
public class BombasDeCombsutivelController {

    private final BombasDeCombustivelService bombasDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody BombasDeCombustivel bombasDeCombustivel){
        bombasDeCombustivelService.criar(bombasDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<BombasDeCombustivel>> buscarBombasDeCombsutivel(){
        return ResponseEntity.ok(bombasDeCombustivelService.buscarBombasDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombasDeCombustivel> buscarBombasPorId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(bombasDeCombustivelService.buscarBombasPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarBombasDeCombustivel(@PathVariable(name = "id") Integer id){
        bombasDeCombustivelService.deletarBombaPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarBombasDeCombustivel(@RequestParam(name = "id") Integer id, @RequestBody BombasDeCombustivel bombasDeCombustivel){
        bombasDeCombustivelService.atualizarBomba(id, bombasDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
