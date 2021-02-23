package br.com.zup.nossositedeviagens.paises;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NovoPaisRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais paraPais() {
        return new Pais(this.nome);
    }
}
