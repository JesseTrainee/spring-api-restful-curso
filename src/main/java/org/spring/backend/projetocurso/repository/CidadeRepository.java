package org.spring.backend.projetocurso.repository;

import org.spring.backend.projetocurso.entity.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntity, Integer>{
	
}
