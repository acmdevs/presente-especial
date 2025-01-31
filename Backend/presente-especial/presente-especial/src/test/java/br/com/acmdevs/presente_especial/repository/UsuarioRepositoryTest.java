package br.com.acmdevs.presente_especial.repository;

import br.com.acmdevs.presente_especial.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario(null, "João", "joao@example.com");
    }

    @Test
    void testSaveUsuario() {
        Usuario savedUsuario = usuarioRepository.save(usuario);

        assertNotNull(savedUsuario);
        assertEquals("João", savedUsuario.getNome());
        assertEquals("joao@example.com", savedUsuario.getEmail());
    }

    @Test
    void testFindById() {
        usuarioRepository.save(usuario);

        Usuario foundUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);

        assertNotNull(foundUsuario);
        assertEquals("João", foundUsuario.getNome());
        assertEquals("joao@example.com", foundUsuario.getEmail());
    }

    @Test
    void testFindById_NotFound() {
        Usuario foundUsuario = usuarioRepository.findById(999L).orElse(null);

        assertNull(foundUsuario);
    }
}
