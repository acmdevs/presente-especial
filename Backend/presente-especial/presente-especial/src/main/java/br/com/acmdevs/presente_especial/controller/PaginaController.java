package br.com.acmdevs.presente_especial.controller;

import br.com.acmdevs.presente_especial.model.Pagina;
import br.com.acmdevs.presente_especial.service.PaginaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagina")
public class PaginaController {

    @Autowired
    private PaginaService paginaService;

    @PostMapping
    public ResponseEntity<Pagina> criarPagina(@RequestBody Pagina pagina) {
        Pagina salvaPagina = paginaService.criarPagina(pagina);
        return new ResponseEntity<>(salvaPagina, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Pagina> listarPaginas() {
        return paginaService.listarPaginas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagina> buscarPaginaPorId(@PathVariable Long id) {
        Optional<Pagina> pagina = paginaService.buscarPaginaPorId(id);
        return pagina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
