package br.rpe.cadastropessoa.api.controllers;

import br.rpe.cadastropessoa.api.presentation.dto.FuncionarioDto;
import br.rpe.cadastropessoa.business.service.converter.ConverterService;
import br.rpe.cadastropessoa.domain.entity.Funcionario;
import br.rpe.cadastropessoa.domain.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Funcionário")
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final ConverterService converterService;

    public FuncionarioController(FuncionarioService funcionarioService, ConverterService converterService) {
        this.funcionarioService = funcionarioService;
        this.converterService = converterService;
    }

    @Operation(summary = "Adicionar um Funcionário")
    @PostMapping
    @ResponseStatus()
    public ResponseEntity<?> create(@RequestBody FuncionarioDto dto) {
        try {
            Funcionario entity = converterService.dtoToFuncionario(dto);
            entity = funcionarioService.create(entity);
            dto = converterService.funcionarioToDto(entity);

            return ResponseEntity.status(HttpStatus.CREATED).body(dto);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Alterar um Funcionário")
    @PutMapping({"{id}"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FuncionarioDto dto) {
        try {
            Funcionario entity = converterService.dtoToFuncionario(dto);
            entity = funcionarioService.update(entity, id);
            dto = converterService.funcionarioToDto(entity);

            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Remover um Funcionário")
    @DeleteMapping({"{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            funcionarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Consultar um Funcionário por id")
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {

        try {
            Funcionario entity = funcionarioService.findById(id);

            FuncionarioDto dto = converterService.funcionarioToDto(entity);

            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Consultar um Funcionário por CPF")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> findByCpf(@PathVariable("cpf") String cpf) {

        try {
            Funcionario entity = funcionarioService.findByCpf(cpf);

            FuncionarioDto dto = converterService.funcionarioToDto(entity);

            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
