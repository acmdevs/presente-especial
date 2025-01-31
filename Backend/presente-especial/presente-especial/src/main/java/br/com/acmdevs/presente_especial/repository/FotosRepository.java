package br.com.acmdevs.presente_especial.repository;

import br.com.acmdevs.presente_especial.model.Fotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotosRepository extends JpaRepository<Fotos, Long> {
    // Aqui você pode adicionar métodos personalizados se precisar
}
