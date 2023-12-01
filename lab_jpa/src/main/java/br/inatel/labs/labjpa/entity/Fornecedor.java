package br.inatel.labs.labjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 200)
    private String razaoSocial;

    @ManyToMany
    private List<Produto> listaProduto;


    // Construtores

    public Fornecedor(){



    }

    public Fornecedor(@NotNull @Size(min = 2, max = 200) String razaoSocial) {
        super();
        this.razaoSocial = razaoSocial;
    }

    // Acessores
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                '}';
    }
}
