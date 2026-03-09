package org.thgcastro.cadastroconsultapostocombustivel.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.Abastecimento;
import org.thgcastro.cadastroconsultapostocombustivel.service.AbastecimentoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abastecimento")
@Tag(name = "Abastecimento", description = "Controlador para abastecer e buscar abastecimentos")
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    @PostMapping
    @Operation(summary = "Abastece", description = "Método para salvar abastecimento")
    @ApiResponse(responseCode = "201", description = "Abastecimento gravado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<Void> abastecer(@RequestParam("quantidadeLitros") Long litros,
                                          @RequestParam("idBomba") Integer idBomba){
        abastecimentoService.abastecer(idBomba, litros);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Encontrar abastecimentos", description = "Método para buscar abastecimentos")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Abastecimento não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @GetMapping
    public ResponseEntity<List<Abastecimento>> buscarAbastecimentos(){
        return ResponseEntity.ok(abastecimentoService.buscarAbastecimentos());
    }
}
