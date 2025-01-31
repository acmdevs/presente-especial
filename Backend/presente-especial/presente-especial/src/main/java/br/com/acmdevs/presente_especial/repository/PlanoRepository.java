package br.com.acmdevs.presente_especial.repository;

import br.com.acmdevs.presente_especial.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
    // Aqui você pode adicionar métodos personalizados se precisar
}
