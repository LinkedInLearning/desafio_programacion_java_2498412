package es.dsrroma.school.java.desafio1.video01_01;

import java.util.Arrays;

public class GeneradorBoletoSimple {
	
	private static final int MIN = 1;
	private static final int MAX = 50;
	private static final int NUMS = 5;

	public static int[] generaBoleto() {
		int[] numeros = new int[NUMS];
		for (int i = 0; i < NUMS; i ++) {
			numeros[i] = generaNumero();
		}
		Arrays.sort(numeros);
		return numeros;
	}

	private static int generaNumero() {
		return (int) (Math.random() * (MAX - MIN + 1)) + MIN;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int[] boleto = generaBoleto();
			System.out.println(Arrays.toString(boleto));
		}
	}
}
