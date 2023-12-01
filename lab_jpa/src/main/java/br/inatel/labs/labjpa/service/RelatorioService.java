package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.labjpa.repository.RelatorioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository repository;

    public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor(){
        return repository.pesquisarTotalCompradoPorFornecedor();
    }


}

