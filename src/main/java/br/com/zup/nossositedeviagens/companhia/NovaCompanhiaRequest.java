package br.com.zup.nossositedeviagens.companhia;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.nossositedeviagens.paises.Pais;
import br.com.zup.nossositedeviagens.validation.UniqueValue;

public class NovaCompanhiaRequest {

	@NotBlank
	@UniqueValue(domaiClass = Companhia.class, attribute = "nome")
	private String nome;

	@NotNull
	private Long idPais;

	public Companhia toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, idPais);
		return new Companhia(nome, pais);
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}
}
