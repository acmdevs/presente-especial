package br.com.acmdevs.presente_especial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_musicas")
@Getter
@Setter
public class Musicas implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pagina_id", nullable = false)
    private Pagina pagina;

    @Column(nullable = false)
    private String url;

    public Musicas() {}

    public Musicas(Long id, Pagina pagina, String url) {
        this.id = id;
        this.pagina = pagina;
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Musicas musicas = (Musicas) o;
        return Objects.equals(id, musicas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
