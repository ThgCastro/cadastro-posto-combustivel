package org.thgcastro.cadastroconsultapostocombustivel.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.TiposDeCombustivel;

public interface TiposDeCombustivelRepository extends JpaRepository<TiposDeCombustivel, Integer> {
}
