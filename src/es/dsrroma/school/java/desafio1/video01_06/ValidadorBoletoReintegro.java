package es.dsrroma.school.java.desafio1.video01_06;

public class ValidadorBoletoReintegro {
	
	public static void main(String[] args) {
		Boleto sorteo = new Boleto();
		System.out.println("Sorteo: " + sorteo);
		for (int i = 0; i < 10000; i++) {
			Boleto apuesta = new Boleto();
			Premio premio = apuesta.validar(sorteo);
			if (premio != Premio.NADA && premio != Premio.REINTEGRO) {
				System.out.println("Premio para " + apuesta + ": " + premio);
			}
		}
		Premio pleno = sorteo.validar(sorteo);
		System.out.println("Premio para " + sorteo + ": " + pleno);
	}
}
