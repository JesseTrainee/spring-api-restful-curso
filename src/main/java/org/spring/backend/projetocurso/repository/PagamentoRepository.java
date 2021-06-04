package org.spring.backend.projetocurso.repository;

import org.spring.backend.projetocurso.entity.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Integer>{
	
}
