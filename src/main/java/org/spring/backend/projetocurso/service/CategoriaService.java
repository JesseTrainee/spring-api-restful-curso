package org.spring.backend.projetocurso.service;

import java.util.Optional;

import org.spring.backend.projetocurso.entity.CategoriaEntity;
import org.spring.backend.projetocurso.repository.CategoriaRepository;
import org.spring.backend.projetocurso.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public CategoriaEntity buscar(Integer id) {
		Optional<CategoriaEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id +
				", Tipo:" + CategoriaEntity.class.getName()));
	}
}
