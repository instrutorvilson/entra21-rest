package com.aula.testes.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

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
	
	public List<Categoria> consultar(){
		return repository.findAll();
	}
	
	public Categoria consultar(Long id){
		Optional<Categoria> opt = repository.findById(id);
		return opt.orElseThrow();
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}
	
}
