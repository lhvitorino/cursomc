package com.lhvitorino.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lhvitorino.cursomc.domain.Categoria;

/* Controlador REST e usado CTRL + SHIFT + o para importar biblioteca  */
@RestController

/* Endpoint  - usar o nome da classe em minuscula e no plural  */
@RequestMapping(value = "/categorias")

/* Esses comandos definiram a classe como REST e respodendo pelo endpoint especificado*/

public class CategoriaResource {
	
	/* Método de teste */
	/* Associar aos verbos HTTP para ser uma função REST */
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1,"Informática");
		Categoria cat2 = new Categoria(1,"Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}

}
