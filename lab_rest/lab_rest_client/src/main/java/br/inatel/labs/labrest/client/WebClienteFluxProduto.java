package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class WebClienteFluxProduto {


    public static void main(String[] args) {
        List<ProdutoDTO> productList = new ArrayList<ProdutoDTO>();

        Flux<ProdutoDTO> productsFlux = WebClient.create(Constantes.BASE_URL).get().uri("/produto").retrieve().bodyToFlux(ProdutoDTO.class);

        productsFlux.subscribe(productList::add);

        productsFlux.blockLast();

        System.out.println("Lista com produtos");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }
}
