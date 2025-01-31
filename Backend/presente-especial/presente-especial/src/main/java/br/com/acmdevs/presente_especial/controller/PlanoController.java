package br.com.acmdevs.presente_especial.controller;

import br.com.acmdevs.presente_especial.model.Plano;
import br.com.acmdevs.presente_especial.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping
    public ResponseEntity<Plano> criarPlano(@RequestBody Plano plano) {
        Plano salvaPlano = planoService.criarPlano(plano);
        return new ResponseEntity<>(salvaPlano, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Plano> listarPlanos() {
        return planoService.listarPlanos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> buscarPlanoPorId(@PathVariable Long id) {
        Optional<Plano> plano = planoService.buscarPlanoPorId(id);
        return plano.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
