package com.authenticacao.authenticacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.authenticacao.authenticacao.entidades.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
     UserDetails findByEmail(String email);
}
