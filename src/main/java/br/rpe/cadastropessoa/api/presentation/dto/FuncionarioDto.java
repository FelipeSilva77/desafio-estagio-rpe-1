package br.rpe.cadastropessoa.api.presentation.dto;

import java.time.LocalDate;

import br.rpe.cadastropessoa.domain.entity.Endereco;
import br.rpe.cadastropessoa.domain.enums.Funcao;
import br.rpe.cadastropessoa.domain.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class FuncionarioDto {
	
	private Long id;

	@CPF
	private String cpf;

	private String nome;
	private Endereco endereco;
	private String telefone;
	private Funcao funcao;
	private Status status;
	private LocalDate dataContratacao;

}
