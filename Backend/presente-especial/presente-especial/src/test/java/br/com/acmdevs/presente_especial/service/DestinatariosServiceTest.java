package br.com.acmdevs.presente_especial.service;

import br.com.acmdevs.presente_especial.model.Destinatarios;
import br.com.acmdevs.presente_especial.repository.DestinatariosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DestinatariosServiceTest {

    @Mock
    private DestinatariosRepository destinatariosRepository;

    @InjectMocks
    private DestinatariosService destinatariosService;

    private Destinatarios destinatarios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        destinatarios = new Destinatarios(1L, "João", "123456789", null);
    }

    @Test
    void testCriarDestinatario() {
        when(destinatariosRepository.save(any(Destinatarios.class))).thenReturn(destinatarios);

        Destinatarios result = destinatariosService.criarDestinatario(destinatarios);

        assertNotNull(result);
        assertEquals("João", result.getNome());
        assertEquals("123456789", result.getNumeroTelefone());
    }

    @Test
    void testBuscarDestinatarioPorId() {
        when(destinatariosRepository.findById(1L)).thenReturn(java.util.Optional.of(destinatarios));

        Destinatarios result = destinatariosService.buscarDestinatarioPorId(1L);

        assertNotNull(result);
        assertEquals("João", result.getNome());
        assertEquals("123456789", result.getNumeroTelefone());
    }

    @Test
    void testBuscarDestinatarioPorId_NotFound() {
        when(destinatariosRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        Destinatarios result = destinatariosService.buscarDestinatarioPorId(1L);

        assertNull(result);
    }
}
