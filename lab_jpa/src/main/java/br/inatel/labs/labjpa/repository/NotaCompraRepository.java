package br.inatel.labs.labjpa.repository;

import br.inatel.labs.labjpa.entity.NotaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaCompraRepository extends JpaRepository<NotaCompra, Long> {


}
