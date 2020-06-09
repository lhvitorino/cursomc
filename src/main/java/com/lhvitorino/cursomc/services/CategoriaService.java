package com.lhvitorino.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhvitorino.cursomc.domain.Categoria;
import com.lhvitorino.cursomc.repositories.CategoriaRepository;
import com.lhvitorino.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService<X> {
	
	@Autowired
	private CategoriaRepository repo;
		
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo: " +
				Categoria.class.getName()));
			
	}

}
