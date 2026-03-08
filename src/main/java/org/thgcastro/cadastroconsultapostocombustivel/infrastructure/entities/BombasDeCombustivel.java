package org.thgcastro.cadastroconsultapostocombustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bombas_combustivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BombasDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nomeBomba;

    @ManyToOne
    @JoinColumn(name = "id_combustivel")
    private TiposDeCombustivel tiposDeCombustivel;
}
