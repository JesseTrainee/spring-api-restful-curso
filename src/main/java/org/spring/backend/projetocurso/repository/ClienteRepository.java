package org.spring.backend.projetocurso.repository;

import org.spring.backend.projetocurso.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{
	
}
