package com.lhvitorino.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* Controlador REST e usado CTRL + SHIFT + o para importar biblioteca  */
@RestController

/* Endpoint  - usar o nome da classe em minuscula e no plural  */
@RequestMapping(value = "/categorias")

/* Esses comandos definiram a classe como REST e respodendo pelo endpoint especificado*/

public class CategoriaResource {
	
	/* Método de teste */
	/* Associar aos verbos HTTP para ser uma função REST */
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST está funcionando";
	}

}
