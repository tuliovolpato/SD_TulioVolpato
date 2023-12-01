package br.inatel.labs.lab_rest_server.model;

import java.math.BigDecimal;

public class Produto {
    // Atributos da classe
    private long id;
    private String descricao;
    private BigDecimal preco;

    public Produto(long id, String descricao, BigDecimal preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }
    public Produto(){

    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
