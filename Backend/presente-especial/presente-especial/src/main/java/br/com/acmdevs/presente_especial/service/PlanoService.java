package br.com.acmdevs.presente_especial.service;

import br.com.acmdevs.presente_especial.model.Plano;
import br.com.acmdevs.presente_especial.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    // Método para criar um plano
    public Plano criarPlano(Plano plano) {
        return planoRepository.save(plano); // Salva o plano no banco de dados
    }

    // Método para listar todos os planos
    public List<Plano> listarPlanos() {
        return planoRepository.findAll(); // Retorna todos os planos do banco de dados
    }

    // Método para buscar um plano pelo id
    public Optional<Plano> buscarPlanoPorId(Long id) {
        return planoRepository.findById(id); // Retorna o plano encontrado ou um Optional vazio
    }

    // Método para excluir um plano
    public void excluirPlano(Long id) {
        planoRepository.deleteById(id); // Exclui o plano pelo id
    }
}
