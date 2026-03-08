package org.thgcastro.cadastroconsultapostocombustivel.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities.BombasDeCombustivel;

public interface BombasDeCombustivelRepository extends JpaRepository<BombasDeCombustivel, Integer> {
}
