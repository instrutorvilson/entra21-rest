package com.auditoria.auditoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auditoria.auditoria.entities.Venda;

@Repository
public interface VendaRepository  extends JpaRepository<Venda, Long>{

}
