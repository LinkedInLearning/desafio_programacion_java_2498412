package es.dsrroma.school.java.desafio1.video01_15;

import java.util.Arrays;
import java.util.OptionalDouble;

public class CalcularMedia {
	
	public static int media(int[] lista) {
		int media = 0;
		for (int i = 0; i < lista.length; i++) {
			media += lista[i];
		}
		return media / lista.length;
	}

	public static double mediaDouble(int[] lista) {
		double media = 0;
		for (int i = 0; i < lista.length; i++) {
			media += lista[i];
		}
		return media / lista.length;
	}

	public static double mediaStreams(int[] array) {
		OptionalDouble media = Arrays.stream(array).average();
		if (media.isPresent()) {
			return media.getAsDouble();
		}
		throw new IllegalStateException("Error no esperado, no hay media");
	}

	public static void main(String[] args) {
		int[] lista = {9, 3, 2, 7, 8};
		System.out.println(media(lista));
		System.out.println(mediaDouble(lista));
		System.out.println(mediaStreams(lista));
	}
}
