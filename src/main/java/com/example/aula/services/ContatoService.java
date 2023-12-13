package com.example.aula.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula.entidades.Contato;
import com.example.aula.exceptions.RecursoNaoEncontrado;
import com.example.aula.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository repo;
	
	public Contato consultar(Long idcontato) {
		Optional<Contato> opt = repo.findById(idcontato);
		Contato ct = opt.orElseThrow(() -> new RecursoNaoEncontrado("Contato não encontrado."));
		return ct;						
	}
}
