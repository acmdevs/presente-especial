package br.com.acmdevs.presente_especial.service;

import br.com.acmdevs.presente_especial.model.Destinatarios;
import br.com.acmdevs.presente_especial.repository.DestinatariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinatariosService {

    @Autowired
    private DestinatariosRepository destinatariosRepository;

    public Destinatarios criarDestinatario(Destinatarios destinatarios) {
        return destinatariosRepository.save(destinatarios);
    }

    public List<Destinatarios> listarDestinatarios() {
        return destinatariosRepository.findAll();
    }

    public Optional<Destinatarios> buscarDestinatarioPorId(Long id) {
        return destinatariosRepository.findById(id);
    }
}
