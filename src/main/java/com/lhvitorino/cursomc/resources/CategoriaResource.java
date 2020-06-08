package com.lhvitorino.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lhvitorino.cursomc.domain.Categoria;
import com.lhvitorino.cursomc.services.CategoriaService;

/* Controlador REST e usado CTRL + SHIFT + o para importar biblioteca  */
@RestController

/* Endpoint  - usar o nome da classe em minuscula e no plural  */
@RequestMapping(value = "/categorias")

/* Esses comandos definiram a classe como REST e respodendo pelo endpoint especificado*/

public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	/* Método de teste */
	/* Associar aos verbos HTTP para ser uma função REST */
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
