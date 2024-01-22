package com.auditoria.auditoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auditoria.auditoria.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
