package br.com.acmdevs.presente_especial.service;

import br.com.acmdevs.presente_especial.model.Usuario;
import br.com.acmdevs.presente_especial.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario(1L, "João", "joao@example.com");
    }

    @Test
    void testCriarUsuario() {
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario result = usuarioService.criarUsuario(usuario);

        assertNotNull(result);
        assertEquals("João", result.getNome());
        assertEquals("joao@example.com", result.getEmail());
    }

    @Test
    void testBuscarUsuarioPorId() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioService.buscarUsuarioPorId(1L);

        assertTrue(result.isPresent());
        Usuario usuario = result.get();
        assertEquals("João", usuario.getNome());
        assertEquals("joao@example.com", usuario.getEmail());
    }

    @Test
    void testBuscarUsuarioPorId_NotFound() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Usuario> result = usuarioService.buscarUsuarioPorId(1L);

        assertFalse(result.isPresent());
    }
}
