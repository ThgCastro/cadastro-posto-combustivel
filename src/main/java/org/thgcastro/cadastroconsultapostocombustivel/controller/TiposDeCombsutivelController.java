package org.thgcastro.cadastroconsultapostocombustivel.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.TiposDeCombustivel;
import org.thgcastro.cadastroconsultapostocombustivel.service.TiposDeCombustivelService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tiposCombustivel")
@Tag(name = "Tipos de Combustíveis", description = "Controlador para criar, buscar, deletar e atualizar os tipos de combustíveis")
public class TiposDeCombsutivelController {

    private final TiposDeCombustivelService tiposDeCombustivelService;

    @PostMapping
    @Operation(summary = "Criar tipo de combustível", description = "Método para criar tipos de combustível")
    @ApiResponse(responseCode = "200", description = "Criação de tipo de combustível realizada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> criar(@RequestBody TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelService.criar(tiposDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    @Operation(summary = "Buscar tipos de combustíveis", description = "Método para buscar todos os tipos de combustíveis")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<List<TiposDeCombustivel>> buscarTiposDeCombsutivel(){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivel());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar tipo de combustível por id", description = "Método para buscar uma tipo de combustível pelo id")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Tipo de combustível não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<TiposDeCombustivel> buscarTiposDeCombsutivelPorId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivelPorId(id));
    }

    @DeleteMapping
    @Operation(summary = "Deletar tipo de combustível", description = "Método para deletar um tipo de combustível pelo id")
    @ApiResponse(responseCode = "200", description = "Deleção realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Tipo de combustível não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> deletarTiposDeCombustivel(@PathVariable(name = "id") Integer id){
        tiposDeCombustivelService.deletarTiposDeCombustivelPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar tipo de combustível", description = "Método para atualizar um tipo de combustível pelo id")
    @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Tipo de combustível não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> atualizarTiposDeCombustivel(@RequestParam(name = "id") Integer id, @RequestBody TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelService.atualizarTiposDeCombustivel(id, tiposDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
