package com.example.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aula.entidades.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{}
