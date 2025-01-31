package br.com.acmdevs.presente_especial.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/admin/**").hasRole("ADMIN")  // Restrição para /admin/**
                                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // Restrição para /user/**
                                .requestMatchers("/**").permitAll()  // Permite acesso público a todas as outras URLs
                )
                .formLogin(withDefaults())  // Configuração do login padrão
                .logout(withDefaults());    // Configuração do logout padrão

        return http.build(); // Retorna a configuração de filtro de segurança
    }
}
