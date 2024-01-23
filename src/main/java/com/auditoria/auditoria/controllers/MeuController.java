package com.auditoria.auditoria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auditoria.auditoria.entities.Cliente;
import com.auditoria.auditoria.entities.Produto;
import com.auditoria.auditoria.entities.Venda;
import com.auditoria.auditoria.repositories.ClienteRepository;
import com.auditoria.auditoria.repositories.ProdutoRepository;
import com.auditoria.auditoria.repositories.VendaRepository;

@RestController
public class MeuController {
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	VendaRepository vendaRepository;
   
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
	
	@GetMapping("/clientes")
	public ResponseEntity<?> getAllClientes(){
		return ResponseEntity.ok().body(clienteRepository.findAll());
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente){
		Cliente newCliente = clienteRepository.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> alterarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
		Cliente oldCliente = clienteRepository.findById(id).get();
		oldCliente.setDescricao(cliente.getDescricao());
				
		Cliente clienteAlterado = clienteRepository.save(oldCliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteAlterado);
	}
	
	@PostMapping("/vendas")
	public ResponseEntity<?> saveVendas(@RequestBody Venda venda){
		Venda newVenda = vendaRepository.save(venda);
		return ResponseEntity.status(HttpStatus.CREATED).body(newVenda);
	}
	
	@PutMapping("/vendas/{id}")
	public ResponseEntity<?> alterarVenda(@PathVariable("id") Long id, @RequestBody Venda venda){
		Venda oldVenda = vendaRepository.findById(id).get();
		oldVenda.setStatus(venda.getStatus());
		oldVenda.setTotal(venda.getTotal());		
		Venda vendaAlterada = vendaRepository.save(oldVenda);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaAlterada);
	}
	
	@DeleteMapping("/vendas/{id}")
	public ResponseEntity<?> deleteVenda(@PathVariable("id") Long id){
		Venda oldVenda = vendaRepository.findById(id).get();
		vendaRepository.delete(oldVenda);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
