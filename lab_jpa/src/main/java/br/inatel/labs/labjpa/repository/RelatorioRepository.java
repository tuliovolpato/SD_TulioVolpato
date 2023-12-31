package br.inatel.labs.labjpa.repository;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatorioRepository extends JpaRepository<NotaCompraItem, Long> {

    @Query("""
            select new br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO
                ( f.razaoSocial
                , sum(i.quantidade * i.valorCompraProduto )
                )
            from NotaCompraItem i
                join i.notaCompra n
                join n.fornecedor f
            group by f.razaoSocial
            """)
    public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor();

}
