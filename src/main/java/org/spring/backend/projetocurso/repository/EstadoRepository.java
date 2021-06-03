package org.spring.backend.projetocurso.repository;

import org.spring.backend.projetocurso.entity.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer>{
	
}
