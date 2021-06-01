package org.spring.backend.projetocurso.repository;

import org.spring.backend.projetocurso.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer>{
	
}
