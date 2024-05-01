package br.rpe.cadastropessoa.business.service.impl;

import br.rpe.cadastropessoa.domain.entity.Funcionario;
import br.rpe.cadastropessoa.domain.enums.Status;
import br.rpe.cadastropessoa.domain.repository.FuncionarioRepository;
import br.rpe.cadastropessoa.domain.service.FuncionarioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(final FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Funcionario create(Funcionario funcionario) {
        if ((findByCpf(funcionario.getCpf()) != null)) {
            throw new IllegalStateException("Funcionario ja cadastrado!");
        }
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario update(Funcionario funcionario) {

        final var funcionarioUp = findById(funcionario.getId());
        funcionarioUp.setEndereco(funcionario.getEndereco());
        funcionarioUp.setCpf(funcionario.getCpf());
        funcionarioUp.setNome(funcionario.getNome());
        funcionarioUp.setStatus(Status.ATIVO);
        funcionarioUp.setTelefone(funcionario.getTelefone());
        funcionarioUp.setDataContratacao(funcionario.getDataContratacao());
        funcionarioUp.setFuncao(funcionario.getFuncao());

        return funcionarioRepository.save(funcionarioUp);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        funcionarioRepository.deleteById(id);
    }

    @Override
    public Funcionario findById(Long id) {
        final var funcionarioOpt = funcionarioRepository.findById(id);

        if (funcionarioOpt.isEmpty()) {
            throw new NoSuchElementException("Funcionário inexistente!");
        }

        return funcionarioOpt.get();
    }

    @Override
    public Funcionario findByCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalStateException("CPF não pode ser nulo!");
        }
        Optional<Funcionario> optional = funcionarioRepository.findByCpf(cpf);
        return optional.orElse(null);
    }


}
