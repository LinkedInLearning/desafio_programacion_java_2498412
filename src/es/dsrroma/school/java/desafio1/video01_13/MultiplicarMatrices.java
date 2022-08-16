package es.dsrroma.school.java.desafio1.video01_13;

public class MultiplicarMatrices {
	
	public static int[][] multiplicar(int[][] m1, int[][] m2) {
		int filas1 = m1.length;
		int cols1 = m1[0].length;
		int filas2 = m2.length;
		int cols2 = m2[0].length;
		
		if (cols1 != filas2) {
			throw new IllegalArgumentException("El número de columnas de la primera matriz "
					+ "debe coincidir con el número de filas de la segunda");
		}
		int[][] producto = new int[filas1][cols2];
		for (int i = 0; i < filas1; i ++) {
			for (int j = 0; j < cols2; j++) {
				int prod = 0;
				for (int k = 0; k < cols1; k++) {
					prod += m1[i][k] * m2[k][j]; 
				}
				producto[i][j] = prod;
			}
		}
		return producto;
	}

	public static void main(String[] args) {
		int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] matriz2 = {{7, 8}, {9, 10}, {11, 12}};
		pintarMatriz(multiplicar(matriz1, matriz2));
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
