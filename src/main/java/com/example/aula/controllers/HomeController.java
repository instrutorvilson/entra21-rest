package com.example.aula.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
	/*http://localhost:8080*/
	@GetMapping("/ola")
	public String olaMundo() {
		return "Hello world";
	}
	
	@GetMapping("/ola/{nome}")
	public String olaMundo(@PathVariable("nome") String nome) {
		return "Hello world " + nome;
	}
	
}
