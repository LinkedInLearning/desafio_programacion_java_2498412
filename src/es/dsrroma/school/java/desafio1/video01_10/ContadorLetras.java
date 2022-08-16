package es.dsrroma.school.java.desafio1.video01_10;

import java.util.Map;
import java.util.TreeMap;

public class ContadorLetras {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Necesito al menos un argumento de entrada.");
			return;
		}
		String texto = args[0];
		Map<Character, Integer> contador = new TreeMap<>();
		for (char l : texto.toCharArray()) {
			Integer cont = contador.get(l);
			if (cont == null) {
				cont = 0;
			}
			contador.put(l, ++cont);
		}
		System.out.println(contador);
	}

}
