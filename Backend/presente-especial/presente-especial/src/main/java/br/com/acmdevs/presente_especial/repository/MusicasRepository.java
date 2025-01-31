package br.com.acmdevs.presente_especial.repository;

import br.com.acmdevs.presente_especial.model.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicasRepository extends JpaRepository<Musicas, Long> {
    // Aqui você pode adicionar métodos personalizados se precisar
}