package org.thgcastro.cadastroconsultapostocombustivel.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Bombas De Combustíveis", description = "Controlador para criar, buscar, salvar e deletar bombas de combustível")
public class BombasDeCombsutivelController {

    private final BombasDeCombustivelService bombasDeCombustivelService;

    @PostMapping
    @Operation(summary = "Criar bomba", description = "Método para criar uma bomba de combustível")
    @ApiResponse(responseCode = "201", description = "Bomba criada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> criar(@RequestBody BombasDeCombustivel bombasDeCombustivel){
        bombasDeCombustivelService.criar(bombasDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    @Operation(summary = "Buscar bombas", description = "Método para buscar todas as bombas de combustíveis")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<List<BombasDeCombustivel>> buscarBombasDeCombsutivel(){
        return ResponseEntity.ok(bombasDeCombustivelService.buscarBombasDeCombustivel());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar bomba por id", description = "Método para buscar uma bomba de combustível pelo id")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Bomba não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<BombasDeCombustivel> buscarBombasPorId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(bombasDeCombustivelService.buscarBombasPorId(id));
    }

    @DeleteMapping
    @Operation(summary = "Deletar bomba", description = "Método para deletar uma bomba de combustível")
    @ApiResponse(responseCode = "200", description = "Bomba deletada com sucesso")
    @ApiResponse(responseCode = "400", description = "Bomba não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> deletarBombasDeCombustivel(@PathVariable(name = "id") Integer id){
        bombasDeCombustivelService.deletarBombaPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar bomba", description = "Método para atualizar uma bomba de combustível existente")
    @ApiResponse(responseCode = "200", description = "Bomba atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Bomba não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> atualizarBombasDeCombustivel(@RequestParam(name = "id") Integer id, @RequestBody BombasDeCombustivel bombasDeCombustivel){
        bombasDeCombustivelService.atualizarBomba(id, bombasDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
