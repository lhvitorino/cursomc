package com.lhvitorino.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhvitorino.cursomc.domain.Cliente;
import com.lhvitorino.cursomc.repositories.ClienteRepository;
import com.lhvitorino.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService<X> {
	
	@Autowired
	private ClienteRepository repo;
		
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo: " +
				Cliente.class.getName()));
			
	}

}
