package br.inatel.labs.labjpa.repository;

import br.inatel.labs.labjpa.entity.NotaCompraItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaCompraItemRepository extends JpaRepository<NotaCompraItem, Long> {



}
