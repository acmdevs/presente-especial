package br.com.acmdevs.presente_especial.service;

import br.com.acmdevs.presente_especial.model.Pagina;
import br.com.acmdevs.presente_especial.repository.PaginaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaginaService {

    @Autowired
    private PaginaRepository paginaRepository;

    public Pagina criarPagina(Pagina pagina) {
        return paginaRepository.save(pagina);
    }

    public List<Pagina> listarPaginas() {
        return paginaRepository.findAll();
    }

    public Optional<Pagina> buscarPaginaPorId(Long id) {
        return paginaRepository.findById(id);
    }
}
