package com.example.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula.entidades.Usuario;
import com.example.aula.exceptions.RecursoJaExistente;
import com.example.aula.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repo;

	public Usuario salvar(Usuario usuario) {
		if(repo.findByEmail(usuario.getEmail()) != null) {
		  throw new RecursoJaExistente("Já existe um usuário com o email informado");	
		}
		repo.save(usuario);
		return usuario;
	}
	
	public List<Usuario> consultar(){
		return repo.findAll();
	}
}
