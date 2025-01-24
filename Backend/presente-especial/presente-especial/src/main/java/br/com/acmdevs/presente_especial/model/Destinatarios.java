package br.com.acmdevs.presente_especial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_destinatarios")
@Getter
@Setter
public class Destinatarios implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(length = 12)
    private String numeroTelefone;

    @ManyToOne
    @JoinColumn(name = "pagina_id", nullable = false)
    private Pagina pagina;

    public Destinatarios() {
    }

    public Destinatarios(Long id, String nome, String numeroTelefone, Pagina pagina) {
        this.id = id;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.pagina = pagina;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Destinatarios that = (Destinatarios) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
