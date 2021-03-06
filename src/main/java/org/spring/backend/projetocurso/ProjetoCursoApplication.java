package org.spring.backend.projetocurso;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.spring.backend.projetocurso.entity.CategoriaEntity;
import org.spring.backend.projetocurso.entity.CidadeEntity;
import org.spring.backend.projetocurso.entity.ClienteEntity;
import org.spring.backend.projetocurso.entity.EnderecoEntity;
import org.spring.backend.projetocurso.entity.EstadoEntity;
import org.spring.backend.projetocurso.entity.ItemPedido;
import org.spring.backend.projetocurso.entity.PagamentoComBoleto;
import org.spring.backend.projetocurso.entity.PagamentoComCartao;
import org.spring.backend.projetocurso.entity.PagamentoEntity;
import org.spring.backend.projetocurso.entity.PedidoEntity;
import org.spring.backend.projetocurso.entity.ProdutoEntity;
import org.spring.backend.projetocurso.enums.EstadoPagamento;
import org.spring.backend.projetocurso.enums.TipoCliente;
import org.spring.backend.projetocurso.repository.CategoriaRepository;
import org.spring.backend.projetocurso.repository.CidadeRepository;
import org.spring.backend.projetocurso.repository.ClienteRepository;
import org.spring.backend.projetocurso.repository.EnderecoRepository;
import org.spring.backend.projetocurso.repository.EstadoRepository;
import org.spring.backend.projetocurso.repository.PagamentoRepository;
import org.spring.backend.projetocurso.repository.PedidoRepository;
import org.spring.backend.projetocurso.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoCursoApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoCursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoriaEntity cat1 = new CategoriaEntity(null,"Inform??tica");
		CategoriaEntity cat2 = new CategoriaEntity(null,"Escrit??rio");
		
		ProdutoEntity p1 = new ProdutoEntity(null,"Computador",2000.00);
		ProdutoEntity p2 = new ProdutoEntity(null,"Impressora",800.00);
		ProdutoEntity p3 = new ProdutoEntity(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));		
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		EstadoEntity est1 = new EstadoEntity(null,"Minas Gerais");
		EstadoEntity est2 = new EstadoEntity(null,"S??o Paulo");
		
		CidadeEntity c1 = new CidadeEntity(null,"Uberl??ndia",est1);
		CidadeEntity c2 = new CidadeEntity(null,"S??o Paulo",est2);
		CidadeEntity c3 = new CidadeEntity(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		ClienteEntity cli1 = new ClienteEntity(null,"Maria Silva","maria@gmail","27410058",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("2664852","36985214"));
		
		EnderecoEntity e1 = new EnderecoEntity(null, "Rua Flores","300","Apto 303","Jardim","98745632",cli1,c2);
		EnderecoEntity e2 = new EnderecoEntity(null, "Avenida Matos","105","Sala 800","Centro","98745655",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		PedidoEntity ped1 = new PedidoEntity(null,sdf.parse("30/09/2017 10:32"),cli1,e1);
		PedidoEntity ped2 = new PedidoEntity(null,sdf.parse("10/10/2017 19:35"),cli1,e2);
		
		PagamentoEntity pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		PagamentoEntity pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2021 12:21"),null);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1, 0.00, 1 , 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1,p3, 0.00, 2 , 80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2, 100.00, 1 , 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll((Arrays.asList(ip3)));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		
	}
	
	

}
