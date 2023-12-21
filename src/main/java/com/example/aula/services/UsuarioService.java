package com.example.aula.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aula.dtos.UsuarioDTO;
import com.example.aula.entidades.Usuario;
import com.example.aula.exceptions.RecursoJaExistente;
import com.example.aula.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	@Autowired
	UsuarioRepository repo;
	
	@Autowired
	BCryptPasswordEncoder passwordEnconder;

	public UsuarioDTO salvar(Usuario usuario) {
		if(repo.findByEmail(usuario.getEmail()) != null) {
		  throw new RecursoJaExistente("Já existe um usuário com o email informado");	
		}
		usuario.setSenha(passwordEnconder.encode(usuario.getSenha()));
		repo.save(usuario);
		return new UsuarioDTO(usuario);
	}
	
	private List<Usuario> consultar(){
		return repo.findAll();
	}
	
	public List<UsuarioDTO> consultarByDTO(){
		List<Usuario> usuarios = consultar();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		for(Usuario user : usuarios) {
			usuariosDTO.add(new UsuarioDTO(user));
		}
		return usuariosDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repo.findByEmail(username);
		return user;
	}
}
