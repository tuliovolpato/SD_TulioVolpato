package br.inatel.labs.labjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class NotaCompraItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal valorCompraProduto;

    @NotNull
    @Positive
    private Integer quantidade;

    @ManyToOne
    private NotaCompra notaCompra;

    @ManyToOne
    private Produto produto;

    // calculo do total do item em tempo de execução:

    public BigDecimal getCalculoTotalItem(){

        return valorCompraProduto.multiply(BigDecimal.valueOf(quantidade));
    }


    // Construtores

    public NotaCompraItem(){



    }

    public NotaCompraItem(BigDecimal valorCompraProduto, Integer quantidade, NotaCompra notaCompra, Produto produto) {
        this.notaCompra = notaCompra;
        this.produto = produto;
        this.valorCompraProduto = valorCompraProduto;
        this.quantidade = quantidade;
    }


    // Acessores

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorCompraProduto() {
        return valorCompraProduto;
    }

    public void setValorCompraProduto(BigDecimal valorCompraProduto) {
        this.valorCompraProduto = valorCompraProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public NotaCompra getNotaCompra() {
        return notaCompra;
    }

    public void setNotaCompra(NotaCompra notaCompra) {
        this.notaCompra = notaCompra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaCompraItem that = (NotaCompraItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "NotaCompraItem{" +
                "id=" + id +
                ", valorCompraProduto=" + valorCompraProduto +
                ", quantidade=" + quantidade +
                '}';
    }
}