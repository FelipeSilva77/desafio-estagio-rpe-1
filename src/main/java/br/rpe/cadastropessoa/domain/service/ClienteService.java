package br.rpe.cadastropessoa.domain.service;

import br.rpe.cadastropessoa.domain.entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {

    Cliente create(Cliente cliente);

    Cliente update(Cliente cliente, Long id);

    void delete(Long id);

    Cliente findById(Long id);

    Cliente findByCpf(String cpf);

}
