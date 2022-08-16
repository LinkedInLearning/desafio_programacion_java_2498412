package es.dsrroma.school.java.desafio1.video01_17;

import java.util.Arrays;

public class BuscarConOrden {

	public static boolean busquedaBinaria(int[] lista, int elem) {
		return busquedaBinariaAux(lista, elem, 0, lista.length-1);
	}
	
	private static boolean busquedaBinariaAux(int[] lista, int elem, int ini, int fin) {
		int centro = Math.floorDiv(fin - ini, 2) + ini;
		int valorCentral = lista[centro];
		if (valorCentral == elem) {
			return true;
		}
		if (fin - ini <= 1) {
			return false;
		}
		if (elem > valorCentral) {
			return busquedaBinariaAux(lista, elem, centro, fin);
		}
//		if (elem < valorCentral) {
		return busquedaBinariaAux(lista, elem, ini, centro);
//		}
	}

	public static void main(String[] args) {
		int[] lista = {9, 3, 2, 7, 8};
		Arrays.sort(lista);
		System.out.println(busquedaBinaria(lista, 7));
		System.out.println(busquedaBinaria(lista, 1));
	}

}
