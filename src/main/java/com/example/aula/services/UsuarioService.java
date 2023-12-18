package com.example.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aula.entidades.Usuario;
import com.example.aula.exceptions.RecursoJaExistente;
import com.example.aula.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	@Autowired
	UsuarioRepository repo;
	
	@Autowired
	BCryptPasswordEncoder passwordEnconder;

	public Usuario salvar(Usuario usuario) {
		if(repo.findByEmail(usuario.getEmail()) != null) {
		  throw new RecursoJaExistente("Já existe um usuário com o email informado");	
		}
		usuario.setSenha(passwordEnconder.encode(usuario.getSenha()));
		repo.save(usuario);
		return usuario;
	}
	
	public List<Usuario> consultar(){
		return repo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repo.findByEmail(username);
		return user;
	}
}
