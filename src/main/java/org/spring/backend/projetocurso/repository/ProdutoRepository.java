package org.spring.backend.projetocurso.repository;

import org.spring.backend.projetocurso.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer>{

	
}
