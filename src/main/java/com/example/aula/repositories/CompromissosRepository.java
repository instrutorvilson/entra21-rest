package com.example.aula.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aula.entidades.Compromisso;
import com.example.aula.entidades.Contato;

@Repository
public interface CompromissosRepository extends JpaRepository<Compromisso, Long> {

	List<Compromisso> findAllByContato(Contato contato);
}
