package br.com.acmdevs.presente_especial.service;

import br.com.acmdevs.presente_especial.model.Fotos;
import br.com.acmdevs.presente_especial.repository.FotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotosService {

    @Autowired
    private FotosRepository fotosRepository;

    public Fotos adicionarFoto(Fotos fotos) {
        return fotosRepository.save(fotos);
    }

    public List<Fotos> listarFotos() {
        return fotosRepository.findAll();
    }

    public Optional<Fotos> buscarFotoPorId(Long id) {
        return fotosRepository.findById(id);
    }
}
