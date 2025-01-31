package br.com.acmdevs.presente_especial.controller;

import br.com.acmdevs.presente_especial.model.Fotos;
import br.com.acmdevs.presente_especial.service.FotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fotos")
public class FotosController {

    @Autowired
    private FotosService fotosService;

    @PostMapping
    public ResponseEntity<Fotos> adicionarFoto(@RequestBody Fotos fotos) {
        Fotos salvaFoto = fotosService.adicionarFoto(fotos);
        return new ResponseEntity<>(salvaFoto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Fotos> listarFotos() {
        return fotosService.listarFotos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fotos> buscarFotoPorId(@PathVariable Long id) {
        Optional<Fotos> foto = fotosService.buscarFotoPorId(id);
        return foto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

