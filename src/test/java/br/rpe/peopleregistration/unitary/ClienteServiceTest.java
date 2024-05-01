package br.rpe.peopleregistration.unitary;

import br.rpe.cadastropessoa.domain.entity.Endereco;
import br.rpe.cadastropessoa.domain.entity.Cliente;
import br.rpe.cadastropessoa.domain.enums.TipoCliente;
import br.rpe.cadastropessoa.domain.service.ClienteService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class ClienteServiceTest {

    @Mock
    private ClienteService clienteService;

    @Mock
    private List<Cliente> clientsMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Order(1)
    @Test
    void testClientSave() {
        final var cliente = newCliente("Fulano", new Endereco());

        verifyNoInteractions(clienteService); //verifica chamadas se há outras além desta
        clienteService.create(cliente);
        verify(clienteService, times(1)).create(cliente);
    }

    @Order(2)
    @Test
    void testUpdateName() {
        when(clientsMock.get(0)).thenReturn(newCliente("Maria", new Endereco()));
        when(clienteService.update(any(Cliente.class), anyLong())).thenReturn(newCliente("João", new Endereco()));

        String upName = "João";
        Cliente cliente = clientsMock.get(0);
        cliente.setNome(upName);

        Cliente clienteUp = clienteService.update(cliente, 1L);

        assertEquals(upName, clienteUp.getNome());
    }

    @Order(3)
    @Test
    void testDelete() {
        assertDoesNotThrow(() -> clienteService.delete(1L));
    }

    private Cliente newCliente(
            final String nome,
            final Endereco endereco
    ) {
        final var cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome(nome);
        cliente.setCpf("111.111.111-11");
        cliente.setEndereco(endereco);
        cliente.setTelefone("(81) 22222-2222");
        cliente.setTipoCliente(TipoCliente.FAXINEIRO);

        return cliente;
    }
}