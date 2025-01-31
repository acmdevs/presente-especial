package br.com.acmdevs.presente_especial.repository;

import br.com.acmdevs.presente_especial.model.Destinatarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinatariosRepository extends JpaRepository<Destinatarios, Long> {
    // Aqui você pode adicionar métodos personalizados se precisar
}
