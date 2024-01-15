package com.authenticacao.authenticacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authenticacao.authenticacao.entidades.Usuario;
import com.authenticacao.authenticacao.repositories.UserRepository;

@RestController
@RequestMapping("/auth")
public class UsuarioController {
   /* private UserRepository repository;
    
    UsuarioController(UserRepository repo){
    	this.repository = repo;
    }*/
    
	@Autowired
	UserRepository repository;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Usuario user){
		if(this.repository.findByEmail(user.getEmail()) != null) {
		  return ResponseEntity.badRequest().build();
		}
		String passwordEndoded = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(passwordEndoded);
		Usuario novoUsuario = repository.save(user);
		return  ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
	}
}
