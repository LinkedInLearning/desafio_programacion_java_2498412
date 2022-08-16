package es.dsrroma.school.java.desafio1.video01_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidadorBoletoSimple {
	
	public static int validarBoleto(int[] boleto, int[] sorteo) {
		int aciertos = 0;
		// convertimos el array a lista para poder usar el contains
		List<Integer> listaSorteo = new ArrayList<Integer>();
		Collections.addAll(listaSorteo, Arrays.stream(sorteo).boxed().toArray(Integer[]::new));
		
		for (int nB : boleto) {
			if (listaSorteo.contains(nB)) {
				aciertos++;
			}
		}
		
		return aciertos;
	}
	
	public static int validarBoletoSinConversion(int[] boleto, int[] sorteo) {
		int aciertos = 0;
		int i = 0;
		
		for (int nB : boleto) {
			// suponemos que ambas listas están ordenadas
			while (i < sorteo.length && nB > sorteo[i]) {
				i++;
			}
			if (i < sorteo.length && nB == sorteo[i]) {
				aciertos++;
			}
		}
		
		return aciertos;
	}
	
	public static void main(String[] args) {
		int[] boleto = {7, 12, 25, 36, 38};
		int[] sorteo = {16, 27, 36, 38, 43};
		System.out.println(validarBoleto(boleto, sorteo));
		System.out.println(validarBoletoSinConversion(boleto, sorteo));

		int[] boleto2 = {7, 12, 25, 36, 38};
		int[] sorteo2 = {16, 27, 37, 39, 43};
		System.out.println(validarBoleto(boleto2, sorteo2));
		System.out.println(validarBoletoSinConversion(boleto2, sorteo2));

		int[] boleto3 = {7, 12, 25, 36, 38};
		int[] sorteo3 = {7, 12, 25, 36, 38};
		System.out.println(validarBoleto(boleto3, sorteo3));
		System.out.println(validarBoletoSinConversion(boleto3, sorteo3));
	}
}
