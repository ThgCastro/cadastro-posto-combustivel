package org.thgcastro.cadastroconsultapostocombustivel.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.Abastecimento;

public interface AbastecimentoRespository extends JpaRepository<Abastecimento, Integer> {
}
