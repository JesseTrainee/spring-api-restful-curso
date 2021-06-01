package org.spring.backend.projetocurso.controller;

import org.spring.backend.projetocurso.entity.CategoriaEntity;
import org.spring.backend.projetocurso.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public ResponseEntity <?> find(@PathVariable Integer id) {
		CategoriaEntity obj = service.buscar(id);
			
		return ResponseEntity.ok().body(obj);
	}
}
