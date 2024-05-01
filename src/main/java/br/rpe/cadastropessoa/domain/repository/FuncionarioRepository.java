package br.rpe.cadastropessoa.domain.repository;

import br.rpe.cadastropessoa.domain.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByCpf(String cpf);

}
