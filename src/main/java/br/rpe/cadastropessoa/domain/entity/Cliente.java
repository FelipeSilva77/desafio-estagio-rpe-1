package br.rpe.cadastropessoa.domain.entity;

import br.rpe.cadastropessoa.domain.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataUltimoServico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCliente tipoCliente;
}
