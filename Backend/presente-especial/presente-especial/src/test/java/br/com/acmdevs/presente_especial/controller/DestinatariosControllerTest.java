package br.com.acmdevs.presente_especial.controller;

import br.com.acmdevs.presente_especial.model.Destinatarios;
import br.com.acmdevs.presente_especial.service.DestinatariosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class DestinatariosControllerTest {

    @Mock
    private DestinatariosService destinatariosService;

    @InjectMocks
    private DestinatariosController destinatariosController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(destinatariosController).build();
    }

    @Test
    void testCreateDestinatario() throws Exception {
        Destinatarios destinatarios = new Destinatarios(1L, "João", "123456789", null);
        when(destinatariosService.criarDestinatario(any(Destinatarios.class))).thenReturn(destinatarios);

        mockMvc.perform(post("/destinatarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(destinatarios)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("João"))
                .andExpect(jsonPath("$.numeroTelefone").value("123456789"));
    }

    @Test
    void testGetDestinatarioById() throws Exception {
        Destinatarios destinatarios = new Destinatarios(1L, "João", "123456789", null);
        when(destinatariosService.buscarDestinatarioPorId(1L)).thenReturn(Optional.of(destinatarios));

        mockMvc.perform(get("/destinatarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João"))
                .andExpect(jsonPath("$.numeroTelefone").value("123456789"));
    }

    @Test
    void testGetDestinatarioById_NotFound() throws Exception {
        when(destinatariosService.buscarDestinatarioPorId(1L)).thenReturn(null);

        mockMvc.perform(get("/destinatarios/1"))
                .andExpect(status().isNotFound());
    }
}
