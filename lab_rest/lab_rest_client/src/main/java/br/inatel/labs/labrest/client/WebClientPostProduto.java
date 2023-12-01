package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

public class WebClientPostProduto {
    public static void main(String[] args) {
        ProdutoDTO novoProduto = new ProdutoDTO();
        novoProduto.setDescricao("Teste");
        novoProduto.setPreco(new BigDecimal(40.0));

        ProdutoDTO produtoCriado = WebClient.create(Constantes.BASE_URL)
                .post()
                .uri("/produto")
                .bodyValue(novoProduto)
                .retrieve()
                .bodyToMono(ProdutoDTO.class)
                .block();

        System.out.println("Produto criado:");
        System.out.println(produtoCriado);
    }
}
