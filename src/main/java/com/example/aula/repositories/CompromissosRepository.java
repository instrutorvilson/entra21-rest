package com.example.aula.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.aula.entidades.Compromisso;
import com.example.aula.entidades.Contato;

@Repository
public interface CompromissosRepository extends JpaRepository<Compromisso, Long> {

	List<Compromisso> findAllByContato(Contato contato);
	
	List<Compromisso> findAllByData(Date data);
	
	
	/*@Query("SELECT c FROM Compromisso c WHERE c.data between :dataInicio AND :dataFim")*/
	@Query(value = "select * from tb_compromissos where data between :dataInicio AND :dataFim", nativeQuery = true)
	List<Compromisso> findAllByEntreDatas(Date dataInicio, Date dataFim);
	
	
}
