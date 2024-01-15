package com.authenticacao.authenticacao.entidades;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario implements UserDetails {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long Id;
	private String email;
	private String password;
	private UsuarioRole role;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioRole getRole() {
		return role;
	}

	public void setRole(UsuarioRole role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UsuarioRole.ADMIN) {
			 return List.of(
					 new SimpleGrantedAuthority("ROLE_ADMIN"),
					 new SimpleGrantedAuthority("ROLE_GERENTE"),
					 new SimpleGrantedAuthority("ROLE_USER")
					 );
		}else {
			if(this.role == UsuarioRole.GERENTE) {
				 return List.of(new SimpleGrantedAuthority("ROLE_GERENTE"));
			}
		}
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	   return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
