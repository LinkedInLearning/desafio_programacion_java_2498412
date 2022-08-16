package es.dsrroma.school.java.desafio1.video01_16;

public class BuscarSinOrden {
	
	public static boolean buscar(int[] lista, int valor) {
		for (int n : lista) {
			if (n == valor) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean buscarWhile(int[] lista, int valor) {
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < lista.length) {
			encontrado = lista[i] == valor;
			i++;
		}
		return encontrado;
	}

	public static void main(String[] args) {
		int[] lista = {9, 3, 2, 7, 8};
		System.out.println(buscar(lista, 7));
		System.out.println(buscarWhile(lista, 7));
		System.out.println(buscar(lista, 1));
		System.out.println(buscarWhile(lista, 1));
	}

}
