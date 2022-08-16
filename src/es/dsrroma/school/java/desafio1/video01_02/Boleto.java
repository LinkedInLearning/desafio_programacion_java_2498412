package es.dsrroma.school.java.desafio1.video01_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Boleto {

	public static final int MIN_N = 1;
	public static final int MAX_N = 50;
	public static final int NUMS = 6;
	public static final int MIN_R = 1;
	public static final int MAX_R = 10;

	private int reintegro;
	private int[] numeros;

	public Boleto() {
		numeros = generaBoleto(MIN_N, MAX_N, NUMS);
		reintegro = generaNumero(MIN_R, MAX_R);
	}

	private static int[] generaBoleto(int min, int max, int nums) {
		List<Integer> boleto = new ArrayList<>();

		for (int i = 0; i < nums; i++) {
			int num = generaNumero(min, max);
			while (boleto.contains(num)) {
				num = generaNumero(min, max);
			}
			boleto.add(num);
		}
		Collections.sort(boleto);
		return boleto.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int generaNumero(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	@Override
	public String toString() {
		return "N: " + Arrays.toString(numeros) + " R: " + reintegro;
	}
}
