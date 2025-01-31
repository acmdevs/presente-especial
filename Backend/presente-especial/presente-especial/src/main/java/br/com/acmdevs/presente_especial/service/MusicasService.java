package br.com.acmdevs.presente_especial.service;

import br.com.acmdevs.presente_especial.model.Musicas;
import br.com.acmdevs.presente_especial.repository.MusicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicasService {

    @Autowired
    private MusicasRepository musicasRepository;

    public Musicas adicionarMusica(Musicas musicas) {
        return musicasRepository.save(musicas);
    }

    public List<Musicas> listarMusicas() {
        return musicasRepository.findAll();
    }

    public Optional<Musicas> buscarMusicaPorId(Long id) {
        return musicasRepository.findById(id);
    }
}
