package com.authenticacao.authenticacao.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContatoController {

	@GetMapping("/contatos")
	public ResponseEntity<?> getContatos(){
		return  ResponseEntity.status(HttpStatus.OK).body("lista de contatos");
	}
	
	@GetMapping("/produtos")
	public ResponseEntity<?> getProdutos(){
		return  ResponseEntity.status(HttpStatus.OK).body("lista de produtos");
	}	
	
	@GetMapping("/clientes")
	public ResponseEntity<?> getClientes(){
		return  ResponseEntity.status(HttpStatus.OK).body("lista de clientes");
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<?> postClientes(){
		return  ResponseEntity.status(HttpStatus.OK).body("post de clients");
	}
	
}
