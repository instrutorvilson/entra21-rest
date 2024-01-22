package com.auditoria.auditoria.entities;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String descricao;
	private double preco;
	private String categoria;
	private Instant createDateAt;
	private Instant updateDateAt;
	private String  criadoPor;
	private String alteradoPor;
	

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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Instant getCreateDateAt() {
		return createDateAt;
	}

	public void setCreateDateAt(Instant createDateAt) {
		this.createDateAt = createDateAt;
	}

	public Instant getUpdateDateAt() {
		return updateDateAt;
	}

	public void setUpdateDateAt(Instant updateDateAt) {
		this.updateDateAt = updateDateAt;
	}

	public String getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}

	public String getAlteradoPor() {
		return alteradoPor;
	}

	public void setAlteradoPor(String alteradoPor) {
		this.alteradoPor = alteradoPor;
	}
	
	@PrePersist
	public void persist() {
		this.createDateAt = Instant.now();
		this.criadoPor = "Joao";
	}
	
	@PreUpdate
	public void update() {
		this.updateDateAt = Instant.now();
		this.alteradoPor = "Maria";
	}
	
	
}
