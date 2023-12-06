package com.example.aula.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula.entidades.Contato;

@RestController
@RequestMapping("/contatos") /*http://localhost:8080*/
public class ContatoController {
	List<Contato> contatos = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<Contato> salvar(@RequestBody Contato contato) {
		contato.setId(contatos.size()+1l);
		contatos.add(contato);
		return ResponseEntity.status(HttpStatus.CREATED).body(contato);
	}
	
	@PutMapping("/{idcontato}")
	public ResponseEntity<Object> alterar(@PathVariable("idcontato") int idcontato,
			@RequestBody Contato contato) {
		for(Contato ct : contatos) {
			if(ct.getId() == idcontato) {
			  ct.setNome(contato.getNome());	
			  ct.setEmail(contato.getEmail());
			  ct.setFone(contato.getFone());
			  return ResponseEntity.status(HttpStatus.OK).body(ct);				
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");		
	}
	
	@DeleteMapping("/{idcontato}")
	public ResponseEntity<Object> excluir(@PathVariable("idcontato") int idcontato) {
		for(Contato ct : contatos) {
			if(ct.getId() == idcontato) {
			  contatos.remove(ct);
			  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();				
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");		
	}
	
	/*@GetMapping
	public List<Contato> consultar() {
		return contatos;
	}*/
	@GetMapping
	public ResponseEntity<List<Contato>> consultar() {
		return ResponseEntity.status(HttpStatus.OK).body(contatos);
	}
	
	@GetMapping("/{idcontato}")
	public ResponseEntity<Object> consultar(@PathVariable("idcontato") Long idcontato) {
		for(Contato contato : contatos) {
			if(contato.getId() == idcontato) {
				return ResponseEntity.status(HttpStatus.OK).body(contato);				
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");		
	}
}
