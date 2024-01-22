package com.auditoria.auditoria.entities;

import com.auditoria.auditoria.auditores.FieldAuditadoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "tb_clientes")
public class Cliente extends FieldAuditadoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String descricao;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
		
}
