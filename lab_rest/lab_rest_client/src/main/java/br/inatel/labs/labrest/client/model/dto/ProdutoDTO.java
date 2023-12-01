package br.inatel.labs.labrest.client.model.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProdutoDTO {
    // Dados = Atributos
    private long id;
    private String descricao;
    private BigDecimal preco;


    // Getters and setter


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
