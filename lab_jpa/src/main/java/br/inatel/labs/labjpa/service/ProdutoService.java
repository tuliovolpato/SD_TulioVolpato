package br.inatel.labs.labjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	
	
	public Produto salvar( Produto p ) {
		return produtoRepository.save( p );
	}
	
	public Optional<Produto> buscarPeloId( Long id ) {
		return produtoRepository.findById( id );
	}
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	public void remove( Produto p ) {
		produtoRepository.delete( p );
	}
	
}
