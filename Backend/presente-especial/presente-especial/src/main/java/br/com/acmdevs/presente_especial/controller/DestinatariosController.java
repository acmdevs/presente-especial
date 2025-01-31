package br.com.acmdevs.presente_especial.controller;

import br.com.acmdevs.presente_especial.model.Destinatarios;
import br.com.acmdevs.presente_especial.service.DestinatariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/destinatarios")
public class DestinatariosController {

    @Autowired
    private DestinatariosService destinatariosService;

    @PostMapping
    public ResponseEntity<Destinatarios> criarDestinatario(@RequestBody Destinatarios destinatarios) {
        Destinatarios criado = destinatariosService.criarDestinatario(destinatarios);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Destinatarios> listarDestinatarios() {
        return destinatariosService.listarDestinatarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destinatarios> buscarDestinatarioPorId(@PathVariable Long id) {
        Optional<Destinatarios> destinatario = destinatariosService.buscarDestinatarioPorId(id);
        return destinatario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
