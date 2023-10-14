package br.inatel.labs.labjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Fornecedor;
import br.inatel.labs.labjpa.repository.FornecedorRepository;

@Service
@Transactional
public class FornecedorService {
	
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor salvar(Fornecedor f) {
		return fornecedorRepository.save( f );
	}

	public Optional<Fornecedor> buscarPeloId(Long id) {
		return fornecedorRepository.findById( id );
	}

	public List<Fornecedor> listar() {
		return fornecedorRepository.findAll();
	}

	public void remover(Fornecedor f) {
		fornecedorRepository.delete( f );
	}
	
}
