package es.dsrroma.school.java.desafio1.video01_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColumnaBingo {
	private LetraBingo letra;
	private int[] nums;

	public ColumnaBingo(LetraBingo letra) {
		this.letra = letra;
		this.nums = generaColumna(letra);
	}

	private int[] generaColumna(LetraBingo letra) {
		List<Integer> numeros = new ArrayList<>();

		for (int i = 0; i < letra.getLon(); i ++) {
			int num = generaNumero(letra.getMin(), letra.getMax());
			while (numeros.contains(num)) {
				num = generaNumero(letra.getMin(), letra.getMax());
			}
			numeros.add(num);
		}
		Collections.sort(numeros);
		return numeros.stream().mapToInt(Integer::intValue).toArray();
	}
	
	private static int generaNumero(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	
	@Override
	public String toString() {
		return letra.getLetra() + ": " + Arrays.toString(nums);
	}
}
