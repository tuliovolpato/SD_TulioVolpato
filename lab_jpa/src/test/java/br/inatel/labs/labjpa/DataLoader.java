package br.inatel.labs.labjpa;

import br.inatel.labs.labjpa.entity.Fornecedor;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.service.FornecedorService;
import br.inatel.labs.labjpa.service.NotaCompraService;
import br.inatel.labs.labjpa.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// @SpringBootTest
class DataLoader {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private FornecedorService fornecedorService;

	@Autowired
	private NotaCompraService notaCompraService;


	// @Test
	void load() {
		//1.Produto
		Produto p1 = new Produto("Furadeira");
		Produto p2 = new Produto("Lixadeira");
		Produto p3 = new Produto("Plaina");
		Produto p4 = new Produto("Tupia");
		Produto p5 = new Produto("Serra Circular");

		p1 = produtoService.salvar(p1);
		p2 = produtoService.salvar(p2);
		p3 = produtoService.salvar(p3);
		p4 = produtoService.salvar(p4);
		p5 = produtoService.salvar(p5);

		List<Produto> produtos = produtoService.listar();
		produtos.forEach(p -> System.out.print(p));

		//2.Fornecedor

		Fornecedor f1 = new Fornecedor("Gasometro Madeiras");
		Fornecedor f2 = new Fornecedor("Loja do Mecânico");

		f1 = fornecedorService.salvar(f1);
		f2 = fornecedorService.salvar(f2);

		List<Fornecedor> fornecedores = fornecedorService.listar();
		fornecedores.forEach(f -> System.out.println(f));

		//3.Nota Compra

		NotaCompra nc1 = new NotaCompra(LocalDate.of(2021, 1, 15),f1);
		nc1 = notaCompraService.salvar(nc1);

		NotaCompra nc2 = new NotaCompra(LocalDate.of(2022, 2, 20),f2);
		nc2 = notaCompraService.salvar(nc2);

		//4. Nota Compra Item

		NotaCompraItem i1_1 = new NotaCompraItem( new BigDecimal("300"), 2, nc1, p2);
		NotaCompraItem i1_2 = new NotaCompraItem(new BigDecimal("1000.00"), 1, nc1, p2);
		NotaCompraItem i1_3 = new NotaCompraItem(new BigDecimal("500.00"), 3, nc1, p3);

		i1_1 = notaCompraService.salvar(i1_1);
		i1_2 = notaCompraService.salvar(i1_2);
		i1_3 = notaCompraService.salvar(i1_3);

		NotaCompraItem i2_1 = new NotaCompraItem(new BigDecimal("400.00"), 7, nc2, p4);
		NotaCompraItem i2_2 = new NotaCompraItem(new BigDecimal("1000.00"), 2, nc2, p2);
		NotaCompraItem i2_3 = new NotaCompraItem(new BigDecimal("700.00"), 1,nc2, p5);

		i2_1 = notaCompraService.salvar(i2_1);
		i2_2 = notaCompraService.salvar(i2_2);
		i2_3 = notaCompraService.salvar(i2_3);

		List<NotaCompraItem> itens = notaCompraService.listarNotaCompraItem();
		itens.forEach(i -> System.out.println(i));



	}

}
