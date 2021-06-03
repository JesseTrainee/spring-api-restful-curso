package org.spring.backend.projetocurso.service;

import java.util.Optional;

import org.spring.backend.projetocurso.entity.CategoriaEntity;
import org.spring.backend.projetocurso.entity.ClienteEntity;
import org.spring.backend.projetocurso.repository.ClienteRepository;
import org.spring.backend.projetocurso.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public ClienteEntity buscar(Integer id) {
		Optional<ClienteEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id +
				", Tipo:" + ClienteEntity.class.getName()));
	}
}
