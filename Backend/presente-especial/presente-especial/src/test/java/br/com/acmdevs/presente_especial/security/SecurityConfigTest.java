package br.com.acmdevs.presente_especial.security;

import br.com.acmdevs.presente_especial.controller.UsuarioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAdminAccess() throws Exception {
        // Simulando autenticação do usuário 'admin' com o papel 'ADMIN'
        User adminUser = new User("admin", "password", List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(adminUser, "password", adminUser.getAuthorities()));

        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk()); // Verifica se a resposta é 200 OK
    }

    @Test
    void testUserAccess() throws Exception {
        // Simulando autenticação do usuário 'user' com o papel 'USER'
        User normalUser = new User("user", "password", List.notify(new SimpleGrantedAuthority("ROLE_USER")));
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(normalUser, "password", normalUser.getAuthorities()));

        mockMvc.perform(get("/user"))
                .andExpect(status().isOk()); // Verifica se a resposta é 200 OK
    }

    @Test
    void testPublicAccess() throws Exception {
        mockMvc.perform(get("/public"))
                .andExpect(status().isOk()); // Verifica se a resposta é 200 OK
    }

    @Test
    void testUnauthorizedAccess() throws Exception {
        // Não há autenticação para o /admin, então deve retornar 401
        mockMvc.perform(get("/admin"))
                .andExpect(status().isUnauthorized()); // Verifica se a resposta é 401 Unauthorized
    }
}
