package br.com.zup.nossositedeviagens.rota;

import br.com.zup.nossositedeviagens.aeroporto.Aeroporto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Aeroporto aeroportoOrigem;

    @ManyToOne
    private Aeroporto aeroportoDestino;

    private LocalDateTime duracao;

    @Deprecated
    public Rota(){}

    public Rota(String nome, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, LocalDateTime duracao) {
        if (nome == null) {
            this.nome = aeroportoOrigem.getNome() +"-" + aeroportoDestino.getNome();
        }
        this.nome = nome;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracao = duracao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Aeroporto getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public Aeroporto getAeroportoDestino() {
        return aeroportoDestino;
    }

    public LocalDateTime getDuracao() {
        return duracao;
    }
}
