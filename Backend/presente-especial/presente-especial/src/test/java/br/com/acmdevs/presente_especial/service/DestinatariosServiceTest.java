package br.com.acmdevs.presente_especial.service;

import br.com.acmdevs.presente_especial.model.Destinatarios;
import br.com.acmdevs.presente_especial.repository.DestinatariosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

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
        when(destinatariosRepository.findById(1L)).thenReturn(Optional.of(destinatarios));

        Optional<Destinatarios> result = destinatariosService.buscarDestinatarioPorId(1L);

        assertTrue(result.isPresent());
        Destinatarios destinatario = result.get();
        assertEquals("João", destinatario.getNome());
        assertEquals("123456789", destinatario.getNumeroTelefone());
    }

    @Test
    void testBuscarDestinatarioPorId_NotFound() {
        when(destinatariosRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Destinatarios> result = destinatariosService.buscarDestinatarioPorId(1L);

        assertFalse(result.isPresent()); // Verifica se o Optional não contém valor
    }

}
