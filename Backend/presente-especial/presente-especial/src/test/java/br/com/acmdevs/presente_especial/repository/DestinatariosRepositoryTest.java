package br.com.acmdevs.presente_especial.repository;

import br.com.acmdevs.presente_especial.model.Destinatarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DestinatariosRepositoryTest {

    @Autowired
    private DestinatariosRepository destinatariosRepository;

    private Destinatarios destinatarios;

    @BeforeEach
    void setUp() {
        destinatarios = new Destinatarios(null, "João", "123456789", null);
    }

    @Test
    void testSaveDestinatario() {
        Destinatarios savedDestinatario = destinatariosRepository.save(destinatarios);

        assertNotNull(savedDestinatario);
        assertEquals("João", savedDestinatario.getNome());
        assertEquals("123456789", savedDestinatario.getNumeroTelefone());
    }

    @Test
    void testFindById() {
        Destinatarios savedDestinatario = destinatariosRepository.save(destinatarios);

        Destinatarios foundDestinatario = destinatariosRepository.findById(savedDestinatario.getId()).orElse(null);

        assertNotNull(foundDestinatario);
        assertEquals("João", foundDestinatario.getNome());
        assertEquals("123456789", foundDestinatario.getNumeroTelefone());
    }

    @Test
    void testFindById_NotFound() {
        Destinatarios foundDestinatario = destinatariosRepository.findById(999L).orElse(null);

        assertNull(foundDestinatario);
    }
}
