package br.inatel.labs.labjpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Endereco {

    @Id
    private String codigo;

    @NotNull
    private String rua;

    @NotNull
    private String numero;

    private String complemento;

    private String bairro;

    @NotNull
    private String cidade;

    @NotNull
    @Size(max = 2)
    private String uf;

    @PrePersist
    private void preencherCodigo(){

        this.codigo = UUID.randomUUID().toString();

    }


    @Override
    public String toString() {
        return "Endereco{" +
                "codigo='" + codigo + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(codigo, endereco.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


    // Acessores

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
