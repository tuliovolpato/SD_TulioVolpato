package br.inatel.labs.labjpa.repository;

import br.inatel.labs.labjpa.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {



}
