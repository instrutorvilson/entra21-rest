package com.authenticacao.authenticacao.entidades;

public enum UsuarioRole {
	ADMIN("admin"),
	USER("user"),
	GERENTE("gerente");
	
	private String role;
	
	UsuarioRole(String role){
	  this.role = role;	
	}
	
	public String getRole() {
		return role;
	}
}
