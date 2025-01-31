package br.com.acmdevs.presente_especial.controller;

import br.com.acmdevs.presente_especial.model.Musicas;
import br.com.acmdevs.presente_especial.service.MusicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/musicas")
public class MusicasController {

    @Autowired
    private MusicasService musicasService;

    @PostMapping
    public ResponseEntity<Musicas> adicionarMusica(@RequestBody Musicas musicas) {
        Musicas salvaMusica = musicasService.adicionarMusica(musicas);
        return new ResponseEntity<>(salvaMusica, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Musicas> listarMusicas() {
        return musicasService.listarMusicas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musicas> buscarMusicaPorId(@PathVariable Long id) {
        Optional<Musicas> musica = musicasService.buscarMusicaPorId(id);
        return musica.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
