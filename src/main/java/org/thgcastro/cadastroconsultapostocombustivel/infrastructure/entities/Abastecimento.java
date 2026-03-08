package org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "abastecimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_bomba")
    private BombasDeCombustivel bombasDeCombustivel;

    @Column(name = "data_abastecimento")
    private LocalDate dataAbastecimento;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "quantidade_litros")
    private Long quantidadeLitros;
}
