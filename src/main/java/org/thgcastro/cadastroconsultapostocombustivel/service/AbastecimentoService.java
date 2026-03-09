package org.thgcastro.cadastroconsultapostocombustivel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.Abastecimento;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.BombasDeCombustivel;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.repositories.AbastecimentoRespository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {
    
    private final AbastecimentoRespository abastecimentoRespository;
    private final BombasDeCombustivelService bombasDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros){
        BombasDeCombustivel bomba = bombasDeCombustivelService.buscarBombasPorId(idBomba);
        BigDecimal valorTotal = bomba.getTiposDeCombustivel().getPrecoLitro().multiply(BigDecimal.valueOf(litros));

        Abastecimento abastecimento = Abastecimento.builder()
                .dataAbastecimento(LocalDate.now())
                .bombasDeCombustivel(bomba)
                .valorTotal(valorTotal)
                .quantidadeLitros(litros)
                .build();

        abastecimentoRespository.save(abastecimento);
    }

    public List<Abastecimento> buscarAbastecimentos(){
        return abastecimentoRespository.findAll();
    }

}
