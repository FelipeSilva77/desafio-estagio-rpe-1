package br.rpe.cadastropessoa.api.presentation.dto;

import br.rpe.cadastropessoa.domain.entity.Endereco;
import br.rpe.cadastropessoa.domain.enums.TipoCliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteDto {

    private Long id;
    private String cpf;
    private String nome;
    private Endereco endereco;
    private String telefone;
    private TipoCliente tipoCliente;
    private LocalDate dataUltimoServico;
}
