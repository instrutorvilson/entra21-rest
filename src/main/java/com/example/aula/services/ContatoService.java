package com.example.aula.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula.entidades.Contato;
import com.example.aula.exceptions.RecursoJaExistente;
import com.example.aula.exceptions.RecursoNaoEncontrado;
import com.example.aula.exceptions.ValidaDadosException;
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
	
	public void excluir(Long id) {
		Contato ct = consultar(id);
		repo.delete(ct);
	}
	
	public Contato salvar(Contato contato) {
		validaCampos(contato);
		
		if (repo.findByEmail(contato.getEmail()) != null) {
			throw new RecursoJaExistente("Contato já cadastrado para esse email");
		}		
		return repo.save(contato);
	}
	
	public Contato alterar(Long idContato, Contato contato) {
		Contato ct = consultar(idContato);
		validaCampos(contato);
		ct = contato;
		return repo.save(ct);
	}
	
	private void validaCampos(Contato contato) {
		if(contato.getNome().equals("")) {
			throw new ValidaDadosException("O nome deve ser informado");
		}
		if(contato.getEmail().equals("")) {
			throw new ValidaDadosException("O email deve ser informado");
		}
		
		if(contato.getFone() == null ) {
			throw new ValidaDadosException("O fone deve ser informado");
		}
		else {
			if(contato.getFone().equals("")) {
				throw new ValidaDadosException("O fone deve ser informado");
			}
		}
	}
	
	
}
