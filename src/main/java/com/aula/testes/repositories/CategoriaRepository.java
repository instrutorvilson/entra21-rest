package com.aula.testes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.testes.entidades.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
