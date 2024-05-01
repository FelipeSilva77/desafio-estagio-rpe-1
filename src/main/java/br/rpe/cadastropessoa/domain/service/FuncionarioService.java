package br.rpe.cadastropessoa.domain.service;

import br.rpe.cadastropessoa.domain.entity.Funcionario;
import org.springframework.stereotype.Service;

@Service
public interface FuncionarioService {

    Funcionario create(Funcionario client);

    Funcionario update(Funcionario client);

    void delete(Long id);

    Funcionario findById(Long id);

    Funcionario findByCpf(String cpf);

}
