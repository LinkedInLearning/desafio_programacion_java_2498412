package es.dsrroma.school.java.desafio1.video01_06;

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

		for (int i = 0; i < nums; i ++) {
			int num = generaNumero(min, max);
			while (boleto.contains(num)) {
				num = generaNumero(min, max);
			}
			boleto.add(num);
		}
		Collections.sort(boleto);
		// (7) Convertimos la lista de Integer a array de int
		return boleto.stream().mapToInt(Integer::intValue).toArray();
	}
	
	private static int generaNumero(int min, int max) {
		// (3) Generamos un número aleatorio entre MIN y MAX (ambos incluídos)
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	
	public Premio validar(Boleto sorteo) {
		int aciertos = aciertos(sorteo);
		boolean reintegro = reintegro(sorteo);
		Premio premio = switch (aciertos) {
			case NUMS -> reintegro ? Premio.PLENO : Premio.SEIS_SIN;
			case NUMS - 1 -> reintegro ? Premio.CINCO_CON : Premio.CINCO_SIN;
			case NUMS - 2 -> reintegro ? Premio.CUATRO_CON : Premio.CUATRO_SIN;
			case NUMS - 3 -> reintegro ? Premio.TRES_CON : Premio.TRES_SIN;
			default -> reintegro ? Premio.REINTEGRO : Premio.NADA;
		};
		return premio; 
	}
	
	private boolean reintegro(Boleto sorteo) {
		return this.reintegro == sorteo.reintegro;
	}

	private int aciertos(Boleto sorteo) {
		int aciertos = 0;
		int i = 0;
		
		for (int nB : numeros) {
			// suponemos que ambas listas están ordenadas
			while (i < sorteo.numeros.length && nB > sorteo.numeros[i]) {
				i++;
			}
			if (i < sorteo.numeros.length && nB == sorteo.numeros[i]) {
				aciertos ++;
			}
		}
		
		return aciertos;
	}

	@Override
	public String toString() {
		return "N: " + Arrays.toString(numeros) + " R: " + reintegro;
	}
}
