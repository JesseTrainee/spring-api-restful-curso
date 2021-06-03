package org.spring.backend.projetocurso.controller;

import org.spring.backend.projetocurso.entity.ClienteEntity;
import org.spring.backend.projetocurso.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public ResponseEntity <?> find(@PathVariable Integer id) {
		ClienteEntity obj = service.buscar(id);
			
		return ResponseEntity.ok().body(obj);
	}
}
