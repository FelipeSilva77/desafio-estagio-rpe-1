package br.rpe.peopleregistration.unitary;

import br.rpe.cadastropessoa.domain.entity.Cliente;
import br.rpe.cadastropessoa.domain.entity.Endereco;
import br.rpe.cadastropessoa.domain.enums.TipoCliente;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.annotation.Testable;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Testable
@DisplayName("Cliente")
class ClienteTest {

    private static Validator validator;


    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"Ful4", "Fulano de Talll xxxxxxxxxxxxxxxxxxxxxxxxx5", "Fulaninho de Talll xxxxxxxxxxxxxxxxxxxxxxxx50"})
    void nameValidTest(String nome) {
        final var cliente = newCliente(
                null,
                "111.111.111-13",
                new Endereco()
        );

        cliente.setNome(nome);
        Set<ConstraintViolation<Cliente>> validacoes = validator.validateProperty(cliente, "nome");

        Assertions.assertEquals(0, validacoes.size());
    }

    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"985.228.024-67", "111.131.151-13", "110.161.704-58"})
    void CpfValidTest(String cpf) {
        final var cliente = newCliente(
                "Fulano",
                null,
                new Endereco()
        );

        cliente.setCpf(cpf);

        Set<ConstraintViolation<Cliente>> validacoes = validator.validateProperty(cliente, "cpf");

        Assertions.assertEquals(0, validacoes.size());
    }

    private Cliente newCliente(
            final String nome,
            final String cpf,
            final Endereco endereco
    ) {
        final var cliente = new Cliente();
        cliente.setId(2L);
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setTelefone("(81) 22222-2222");
        cliente.setTipoCliente(TipoCliente.FAXINEIRO);

        return cliente;
    }
}
