package org.spring.backend.projetocurso.repository;

import org.spring.backend.projetocurso.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer>{
	
}
