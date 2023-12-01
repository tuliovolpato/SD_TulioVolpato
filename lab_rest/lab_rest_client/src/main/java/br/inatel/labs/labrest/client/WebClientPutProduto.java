package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientPutProduto {
    public static void main(String[] args) {

        ProdutoDTO produtoExistente = new ProdutoDTO();
        produtoExistente.setId(1L);
        produtoExistente.setDescricao("Furadeira a bateria");

        ResponseEntity<Void> responseEntity = WebClient.create(Constantes.BASE_URL)
                .put()
                .uri("/produto/1")
                .bodyValue(produtoExistente)
                .retrieve()
                .toBodilessEntity()
                .block();

        System.out.println("Produto Atualizado");
        System.out.println("Status da Resposta: " + responseEntity.getStatusCode());
    }
}
