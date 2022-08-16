package es.dsrroma.school.java.desafio1.video01_14;

public class CalcularMinimo {
	
	public static int minimo(int[] lista) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] < min) {
				min = lista[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] lista = {9, 3, 2, 7, 8};
		System.out.println(minimo(lista));
	}

}
