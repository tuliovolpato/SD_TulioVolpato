package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;

public class WebClientGetMonoProdutoPeloId {

    public static void main(String[] args) {

        try{
            Mono<ProdutoDTO> productMono = WebClient.create(Constantes.BASE_URL).get().uri("/produto/1").retrieve().bodyToMono(ProdutoDTO.class);

            productMono.subscribe();

            ProdutoDTO produto = productMono.block();

            System.out.println("Produto encontrado");
            System.out.println(produto);

        }catch (WebClientException e){
            System.out.println("Status Code: "+e.getMessage());
        }


    }

}
