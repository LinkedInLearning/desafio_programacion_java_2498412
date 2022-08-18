package es.dsrroma.school.java.desafio1.video01_12;

public class SumarMatrices {
	
	public static int[][] sumar(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			throw new IllegalArgumentException(
				"Las dos matrices a sumar deben tener las mismas dimensiones");
		}
		int[][] suma = new int[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i ++) {
			for (int j = 0; j < m1[0].length; j++) {
				suma[i][j] = m1[i][j] + m2[i][j];
			}
		}
		return suma;
	}

	public static void main(String[] args) {
		int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] matriz2 = {{10, 20, 30}, {40, 50, 60}};
		pintarMatriz(sumar(matriz1, matriz2));
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
