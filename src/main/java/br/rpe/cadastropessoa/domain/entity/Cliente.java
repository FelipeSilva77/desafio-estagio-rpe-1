package br.rpe.cadastropessoa.domain.entity;

import br.rpe.cadastropessoa.domain.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class Cliente extends Pessoa {

    @Serial
    private static final long serialVersionUID = 7773220926013539041L;

    @Column(nullable = false)
    private LocalDate dataUltimoServico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCliente tipoCliente;
}
