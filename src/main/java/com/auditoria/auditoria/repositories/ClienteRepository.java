package com.auditoria.auditoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auditoria.auditoria.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{}
