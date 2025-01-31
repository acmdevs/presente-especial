package br.com.acmdevs.presente_especial.repository;

import br.com.acmdevs.presente_especial.model.Pagina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginaRepository extends JpaRepository<Pagina, Long> {
    // Aqui você pode adicionar métodos personalizados se precisar
}
