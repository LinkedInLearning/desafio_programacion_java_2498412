package es.dsrroma.school.java.desafio1.video01_11;

public class RellenarMatriz {

	public static void main(String[] args) {
		try {
			int x = Integer.valueOf(args[0]);
			int y = Integer.valueOf(args[1]);
			int[][] matriz = new int[x][y];
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					matriz[i][j] = i*i + j; // la fórmula que queramos
				}
			}
			pintarMatriz(matriz);
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			System.err.println("Necesito al menos dos argumentos, numéricos, de entrada.");			
		}
	}

	private static void pintarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
