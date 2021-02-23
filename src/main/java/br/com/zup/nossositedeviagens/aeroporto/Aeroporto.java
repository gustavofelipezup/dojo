package br.com.zup.nossositedeviagens.aeroporto;

import br.com.zup.nossositedeviagens.paises.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;
    @NotNull
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Aeroporto() {
    }

    public Aeroporto(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Aeroporto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Pais getPais() {
        return pais;
    }

    public String getNome() {
        return nome;
    }
}
