package es.dsrroma.school.java.desafio1.video01_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SorteoNavidad {
	private static final int MIN_NUM = 0;
	private static final int MAX_NUM = 99999;
	private static final int DIG = 
		(int) Math.floor(Math.log10(MAX_NUM) + 1);
	
	private static final Random R = new Random();
	
	private List<Integer> bomboNumeros = new ArrayList<>();
	private List<TipoPremio> bomboPremios = new ArrayList<>();
	private Map<Integer, TipoPremio> tablaPremios = new HashMap<>();

	public SorteoNavidad() {
		for (int i = MIN_NUM; i <= MAX_NUM; i++) {
			bomboNumeros.add(i);
		}
		for (TipoPremio premio : TipoPremio.values()) {
			for (int i = 0; i < premio.getNumPremios(); i ++) {
				bomboPremios.add(premio);
			}
		}
	}
	
	public void sorteo() {
		while (!bomboPremios.isEmpty()) {
			int premioAlea = R.nextInt(bomboPremios.size());
			TipoPremio premio = bomboPremios.remove(premioAlea);
			int numAlea = R.nextInt(bomboNumeros.size());
			int num = bomboNumeros.remove(numAlea);
			tablaPremios.put(num, premio);
		}
	}
	
	public void printTablaPorNum() {
		System.out.println("Tabla ordenada por número");
		if (tablaPremios.isEmpty()) {
			System.err.println("Sorteo pendiente");
		}
		tablaPremios.keySet().stream().sorted().forEach(
				k -> System.out.println(formateaLinea(k, tablaPremios.get(k)))
		);
	}
	
	public void printTablaPorPremio() {
		System.out.println("Tabla ordenada por premios");
		if (tablaPremios.isEmpty()) {
			System.err.println("Sorteo pendiente");
		}
		tablaPremios.entrySet().stream().sorted(
				new Comparator<Map.Entry<Integer, TipoPremio>>() {
					   	public int compare(Map.Entry<Integer, TipoPremio> o1, 
						 		Map.Entry<Integer, TipoPremio> o2) {
					        return o1.getValue().compareTo(o2.getValue());
					    }
				}
			).forEach(
				e -> System.out.println(formateaLinea(e))
		);
	}
	
	private String formateaLinea(Integer num, TipoPremio premio) {
		return String.format("%0" + DIG + "d", num) + ": " 
			+ premio.getPremioPorEuro() + "€";
	}
	
	private String formateaLinea(Map.Entry<Integer, TipoPremio> entry) {
		return formateaLinea(entry.getKey(), entry.getValue());
	}
	
	public static void main(String[] args) {
		SorteoNavidad sorteo = new SorteoNavidad();
		sorteo.sorteo();
		sorteo.printTablaPorNum();
		System.out.println("================");
		sorteo.printTablaPorPremio();
	}
}
