package org.spring.backend.projetocurso;

import java.util.Arrays;

import org.spring.backend.projetocurso.entity.CategoriaEntity;
import org.spring.backend.projetocurso.entity.CidadeEntity;
import org.spring.backend.projetocurso.entity.EstadoEntity;
import org.spring.backend.projetocurso.entity.ProdutoEntity;
import org.spring.backend.projetocurso.repository.CategoriaRepository;
import org.spring.backend.projetocurso.repository.CidadeRepository;
import org.spring.backend.projetocurso.repository.EstadoRepository;
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
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoCursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoriaEntity cat1 = new CategoriaEntity(null,"Informática");
		CategoriaEntity cat2 = new CategoriaEntity(null,"Escritório");
		
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
		EstadoEntity est2 = new EstadoEntity(null,"São Paulo");
		
		CidadeEntity c1 = new CidadeEntity(null,"Uberlândia",est1);
		CidadeEntity c2 = new CidadeEntity(null,"São Paulo",est2);
		CidadeEntity c3 = new CidadeEntity(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	}
	
	

}
