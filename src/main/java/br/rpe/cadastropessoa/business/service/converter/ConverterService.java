package br.rpe.cadastropessoa.business.service.converter;

import br.rpe.cadastropessoa.api.presentation.dto.ClienteDto;
import br.rpe.cadastropessoa.api.presentation.dto.FuncionarioDto;
import br.rpe.cadastropessoa.domain.entity.Cliente;
import br.rpe.cadastropessoa.domain.entity.Funcionario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    private final ModelMapper mapper;

    public ConverterService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Funcionario dtoToFuncionario(FuncionarioDto dto) {
        return mapper.map(dto, Funcionario.class);
    }

    public FuncionarioDto funcionarioToDto(Funcionario entity) {
        return mapper.map(entity, FuncionarioDto.class);
    }

    public Cliente dtoToCliente(ClienteDto dto) {
        return mapper.map(dto, Cliente.class);
    }

    public ClienteDto clienteToDto(Cliente entity) {
        return mapper.map(entity, ClienteDto.class);
    }
}
