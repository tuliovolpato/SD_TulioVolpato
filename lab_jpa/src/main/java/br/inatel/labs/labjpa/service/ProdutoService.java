package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto p){

       return produtoRepository.save(p);

    }

    public Optional<Produto> BuscarPeloId (Long id) {

        return produtoRepository.findById(id);

    }

    public List<Produto> listar(){

        return produtoRepository.findAll();

    }

    public void remove(Produto p){

        produtoRepository.delete(p);

    }




}
