package br.inatel.labs.lab_rest_server.service;

import br.inatel.labs.lab_rest_server.model.Produto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProdutoService {
    // Atributos
    private List<Produto> produtos = new ArrayList<>();

    // Inserindo dados
    @PostConstruct
    private void setup(){
        // Instanciando 3 produtos
        Produto prd1= new Produto(1L,"Furadeira",new BigDecimal("230.00"));
        Produto prd2= new Produto(2L,"Serra Circular",new BigDecimal("500.00"));
        Produto prd3= new Produto(3L,"Parafusadeira",new BigDecimal("400.00"));

        // Insert produtos
        produtos.add(prd1);
        produtos.add(prd2);
        produtos.add(prd3);

    }
    // Métodos de serviço
    public List<Produto> findAll(){
        return this.produtos;
    }

    public Optional<Produto> findById(long id){
        return produtos.stream().filter(prd->prd.getId()==id).findFirst();
    }

    public Produto create(Produto p){
        long id = new Random().nextLong();
        p.setId( id );
        produtos.add( p );
        return p;

    }

    public void update(Produto p){
        produtos.remove( p );
        produtos.add( p );

    }

    public void remove(Produto p){
        produtos.remove(p);
    }



}
