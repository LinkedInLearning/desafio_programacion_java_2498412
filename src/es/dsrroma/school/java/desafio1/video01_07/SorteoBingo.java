package es.dsrroma.school.java.desafio1.video01_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SorteoBingo {
	private static final int MIN = 1;
	private static final int MAX = 75;
	private static final int CADENCIA = 3000; // ms
	private static final Random R = new Random();
	
	private List<Integer> bolas = new ArrayList<>();
	
	public SorteoBingo() {
		for (int i = MIN; i <= MAX; i++) {
			bolas.add(i);
		}
	}
	
	public void sortear() {
		try {
			while (!bolas.isEmpty()) {
				int bola = extraerBola();
				System.out.print(bola + " ");
				Thread.sleep(CADENCIA);
			}
		} catch (InterruptedException e) {
			System.out.println("\n¡BINGO!");
		}
	}
	
	private int extraerBola() {
		int pos = R.nextInt(bolas.size());
		return bolas.remove(pos);
	}
	
	public static void main(String[] args) {
		SorteoBingo sorteo = new SorteoBingo();
		sorteo.sortear();
	}
}
