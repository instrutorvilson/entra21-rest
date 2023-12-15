package com.example.aula.entidades;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_contatos")
public class Contato {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	
	@Column( length = 50)
	private String nome;
	@Column( length = 100)
	private String email;
	@Column( length = 14)
	private String fone;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Instant createdAt;
	
	@Column( columnDefinition = "DATETIME")
	private Instant updatedAt;
	
	@PrePersist
	public void prePersit() {
		createdAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

}
