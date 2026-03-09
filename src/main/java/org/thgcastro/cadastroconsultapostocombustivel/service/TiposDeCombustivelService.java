package org.thgcastro.cadastroconsultapostocombustivel.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.TiposDeCombustivel;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.repositories.TiposDeCombustivelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiposDeCombustivelService {

    private final TiposDeCombustivelRepository tiposDeCombustivelRepository;

    public void criar(TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelRepository.save(tiposDeCombustivel);
    }

    public List<TiposDeCombustivel> buscarTiposDeCombustivel(){
        return tiposDeCombustivelRepository.findAll();
    }

    public TiposDeCombustivel buscarTiposDeCombustivelPorId(Integer id){
        return tiposDeCombustivelRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Tipo de combustível não encontrada pelo id: " + id));
    }

    @Transactional
    public void deletarTiposDeCombustivelPorId(Integer id){
        tiposDeCombustivelRepository.deleteById(id);
    }

    public void atualizarTiposDeCombustivel(Integer id ,TiposDeCombustivel tiposDeCombustivel){
        TiposDeCombustivel tipos = buscarTiposDeCombustivelPorId(id);
        tiposDeCombustivel.setId(tipos.getId());
        tiposDeCombustivelRepository.save(tiposDeCombustivel);
    }
}
