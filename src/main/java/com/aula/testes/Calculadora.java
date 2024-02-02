package com.aula.testes;

public class Calculadora {

	public double somar(double n1, double n2) {
		if(n1 < 0) {
			throw new RuntimeException("Não permitimos valor negativo");
		}
		return n1 + n2;
	}

}
