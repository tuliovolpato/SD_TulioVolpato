package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;
import jakarta.validation.constraints.AssertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class RelatorioServiceTest {

    @Autowired
    private RelatorioService service;

    @Test
    void test(){

        List<TotalCompradoPorFornecedorDTO> listaDTO = service.pesquisarTotalCompradoPorFornecedor();

        assertFalse(listaDTO.isEmpty());

    //    System.out.println("FornecedorRazaoSocial : TotalComprado");
    //    listaDTO.forEach(r -> {
    //        System.out.print(r.fornecedorRazaoSocial());
    //        System.out.print(" : ");
    //        System.out.println(r.totalComprado());

    //    });

        listaDTO.forEach(r -> System.out.println(r));

    }

}
