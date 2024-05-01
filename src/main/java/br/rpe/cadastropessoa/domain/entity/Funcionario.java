package br.rpe.cadastropessoa.domain.entity;

import br.rpe.cadastropessoa.domain.enums.Funcao;
import br.rpe.cadastropessoa.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class Funcionario extends Pessoa {

    @Serial
    private static final long serialVersionUID = 9034647921071374718L;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Funcao funcao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDate dataContratacao;
}
