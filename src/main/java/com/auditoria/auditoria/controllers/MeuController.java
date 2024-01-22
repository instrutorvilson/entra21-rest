package com.auditoria.auditoria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auditoria.auditoria.entities.Produto;
import com.auditoria.auditoria.repositories.ProdutoRepository;

@RestController
public class MeuController {
	@Autowired
	ProdutoRepository produtoRepository;
   
	//http://localhost:8080/minhalista
	@GetMapping("/minhalista")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok("minha lista");
	}
	
	@GetMapping("/produtos")
	public ResponseEntity<?> getAllProducts(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<?> saveProduct(@RequestBody Produto prod){
		Produto newProd = produtoRepository.save(prod);
		return ResponseEntity.status(HttpStatus.CREATED).body(newProd);
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<?> alterarProduct(@PathVariable("id") Long id, @RequestBody Produto prod){
		Produto oldProd = produtoRepository.findById(id).get();
		oldProd.setDescricao(prod.getDescricao());
		oldProd.setPreco(prod.getPreco());
		oldProd.setCategoria(prod.getCategoria());
		
		Produto prodAlterado = produtoRepository.save(oldProd);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(prodAlterado);
	}
}
