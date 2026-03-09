package org.thgcastro.cadastroconsultapostocombustivel.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.BombasDeCombustivel;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.repositories.BombasDeCombustivelRepository;

@Service
@RequiredArgsConstructor
public class BombasDeCombustivelService {

    private final BombasDeCombustivelRepository bombasDeCombustivelRepository;

    public void criar(BombasDeCombustivel bombasDeCombustivel){
        bombasDeCombustivelRepository.save(bombasDeCombustivel);
    }

    public BombasDeCombustivel buscarBombasPorId(Integer id){
        return bombasDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Bomba não encontrada pelo id: " + id));
    }

    @Transactional
    public void deletarBombaPorId(Integer id){
        bombasDeCombustivelRepository.deleteById(id);
    }

    public void atualizarBomba(Integer id ,BombasDeCombustivel bombasDeCombustivel){
        BombasDeCombustivel bomba = buscarBombasPorId(id);
        bombasDeCombustivel.setId(bomba.getId());
        bombasDeCombustivelRepository.save(bombasDeCombustivel);
    }

}
