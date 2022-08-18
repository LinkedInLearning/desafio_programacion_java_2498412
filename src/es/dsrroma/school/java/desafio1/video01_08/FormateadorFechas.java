package es.dsrroma.school.java.desafio1.video01_08;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FormateadorFechas {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Indica el formato de fecha deseado: ");
			String patron = s.nextLine();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(patron);
				String ahora = sdf.format(new Date());
				System.out.println("Fecha actual: " + ahora);
			} catch (IllegalArgumentException iae) {
				System.err.println(String.format(
					"El patrón indicado '%s' no es válido.", patron));
			}
		}
	}

}
