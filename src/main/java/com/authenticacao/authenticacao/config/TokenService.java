package com.authenticacao.authenticacao.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.authenticacao.authenticacao.entidades.Usuario;

@Service
public class TokenService {
	@Value("${api.security.token.secret}")
	private String segredo;
	
	@Value("${api.security.token.issuer}")
	private String issuer;

	public String generateToken(Usuario user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(segredo);
			String token = JWT.create().withIssuer(issuer).withSubject(user.getEmail())
					.withExpiresAt(genExpirationDate()).sign(algorithm);

			return token;
		} catch (JWTCreationException ex) {
			throw new RuntimeException("Erro ao criar token", ex);
		}
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(segredo);
            return JWT.require(algorithm)
            	    .withIssuer(issuer)
            	    .build()
            	    .verify(token)
            	    .getSubject();
		} catch (JWTCreationException ex) {
			return "";
		}

	}

	private Instant genExpirationDate() {
		return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-3:00"));
	}
}
