package org.spring.backend.projetocurso.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.spring.backend.projetocurso.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e , HttpServletRequest request){
		
	StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(),System.currentTimeMillis());
	return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}