package es.dsrroma.school.java.desafio1.video01_04;

public enum TipoPremio {
	GORDO (20000, 1), 
	SEGUNDO (6250, 1),
	TERCERO (2500, 1),
	CUARTO (1000, 2),
	QUINTO (300, 8),
	PEDREA (5, 18);// 1794);
	
	private int premioPorEuro;
	private int numPremios;

	TipoPremio(int premioPorEuro, int numPremios) {
		this.premioPorEuro = premioPorEuro;
		this.numPremios = numPremios;
	}

	public int getPremioPorEuro() {
		return premioPorEuro;
	}

	public int getNumPremios() {
		return numPremios;
	}
}
