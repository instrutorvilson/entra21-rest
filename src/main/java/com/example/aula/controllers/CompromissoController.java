package com.example.aula.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula.entidades.Compromisso;
import com.example.aula.entidades.Contato;
import com.example.aula.repositories.CompromissosRepository;
import com.example.aula.repositories.ContatoRepository;
import com.example.aula.services.ContatoService;

@RestController
@RequestMapping("/compromissos")
public class CompromissoController {
    @Autowired
	CompromissosRepository repo;
    
    @Autowired
    ContatoService serviceContato;
    
    @GetMapping
    public ResponseEntity<List<Compromisso>> getAll(){
    	return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
    }
    
    @GetMapping("/contato")
    public ResponseEntity<List<Compromisso>> getAllByContato(@RequestParam("idcontato") Long id){
    	Contato contato = serviceContato.consultar(id);
    	return ResponseEntity.status(HttpStatus.OK).body(repo.findAllByContato(contato));
    }
    
       
    @PostMapping
    public ResponseEntity<Compromisso> save(@RequestBody Compromisso compromisso){
    	//Compromisso comp = repo.save(compromisso);
    	return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(compromisso));
    }
}
  