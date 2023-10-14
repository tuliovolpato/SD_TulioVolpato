package br.inatel.labs.labjpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Endereco;
import jakarta.persistence.EntityManager;

@Service
@Transactional
public class EnderecoService {

	private EntityManager em;
	
	public Endereco salvar(Endereco e) {
		return em.merge( e );
	}
	
}
