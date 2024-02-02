package com.aula.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
public class CalculadoraTest {

	@Test
	public void testarSomaComValoresPositivos() {
	  //Arrange
	  Calculadora calculadora = new Calculadora();
	  //Act
	  double valorEsperado = calculadora.somar(20.0, 10.0);
	  //assert
	  assertEquals(valorEsperado, 30);	  
	}
	
	@Test
	public void testarSomaComValoresNegativosLancaRuntimeException() {
	  //Arrange
	  Calculadora calculadora = new Calculadora();	 
	  //Act
	  RuntimeException ex = assertThrows(RuntimeException.class, () -> calculadora.somar(-20.0, 10.0));
	  //assert
	  assertThat(ex, instanceOf(RuntimeException.class));
	}
	
	@Test
	public void testarSomaComValoresNegativosLancaRuntimeExceptionJUnit() {
	  //Arrange
	  Calculadora calculadora = new Calculadora();	 
	  //Act
	  Throwable ex = assertThrows(RuntimeException.class, () -> calculadora.somar(-20.0, 10.0));
	  //assert
	  assertEquals(ex.getMessage(), "Não permitimos valor negativo");
	}
}
