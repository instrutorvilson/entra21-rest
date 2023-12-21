package com.example.aula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula.dtos.UsuarioDTO;
import com.example.aula.entidades.Usuario;
import com.example.aula.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getAll(){
		/*List<Usuario> usuarios = service.consultar();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		for(Usuario user : usuarios) {
			usuariosDTO.add(new UsuarioDTO(user));
		}
		
		return ResponseEntity.ok(usuariosDTO);*/
	    return ResponseEntity.ok(service.consultarByDTO());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(usuario));
	}
}
