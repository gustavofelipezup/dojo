package br.com.zup.nossositedeviagens.companhia;

import br.com.zup.nossositedeviagens.paises.Pais;
import br.com.zup.nossositedeviagens.validation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    private LocalDateTime instanteCriacao;

    @ManyToOne
    @NotNull
    private Pais pais;

    public Companhia(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
        this.instanteCriacao = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	   
    
}
