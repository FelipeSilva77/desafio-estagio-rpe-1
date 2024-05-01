package br.rpe.cadastropessoa.business.service.impl;

import br.rpe.cadastropessoa.domain.entity.Cliente;
import br.rpe.cadastropessoa.domain.repository.ClienteRepository;
import br.rpe.cadastropessoa.domain.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(final ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente create(Cliente cliente) {
        final Cliente clienteUp = findByCpf(cliente.getCpf());
        if (clienteUp != null) {
            throw new IllegalStateException("Cliente ja cadastrado!");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        Cliente clienteUp = findById(cliente.getId());

        clienteUp.setEndereco(cliente.getEndereco());
        clienteUp.setCpf(cliente.getCpf());
        clienteUp.setDataUltimoServico(cliente.getDataUltimoServico());
        clienteUp.setNome(cliente.getNome());
        clienteUp.setTelefone(cliente.getTelefone());

        return clienteRepository.save(clienteUp);
    }

    @Override
    public void delete(Long id) {
        if (findById(id) == null || id == null) {
            throw new NoSuchElementException("Cliente inexistente!");
        }
        clienteRepository.deleteById(id);
    }


    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new NoSuchElementException("Cliente inexistente!");
        }

        return clienteOptional.get();
    }

    @Override
    public Cliente findByCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalStateException("CPF cannot be null");
        }
        Optional<Cliente> optional = clienteRepository.findByCpf(cpf);
        return optional.orElse(null);
    }
}
