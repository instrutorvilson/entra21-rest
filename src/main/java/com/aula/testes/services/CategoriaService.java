package com.aula.testes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.testes.entidades.Categoria;
import com.aula.testes.repositories.CategoriaRepository;

@Service
public class CategoriaService {
  
	@Autowired
	CategoriaRepository repository;
	
	public Categoria salvar(Categoria categoria) {
	  if(categoria.getDescricao().equals("")) {
		 throw new RuntimeException("A descrição precisa ser informada"); 
	  }
	  return(repository.save(categoria));
	}
	
	
}
