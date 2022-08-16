package es.dsrroma.school.java.desafio1.video01_09;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EdadExacta {
	
	private static final String PATRON = "dd/MM/yyyy";

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Indica tu fecha de nacimiento (" + PATRON + ")");
			String fechaLeida = s.nextLine();
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PATRON);
				LocalDate fecha = LocalDate.parse(fechaLeida, dtf);
				LocalDate ahora = LocalDate.now();
				Period edad = Period.between(fecha, ahora);
				System.out.println(String.format("Edad: %d años, %d meses y %d días",
						edad.getYears(), edad.getMonths(), edad.getDays()));
				if (edad.getMonths() == 0) {
					if (edad.getDays() == 0) {
						System.out.println("¡FELICIDADES! ¡Hoy es tu cumpleaños!");
					} else {
						System.out.println("¡Felicidades! Tu cumpleaños ha sido hace poco...");						
					}
				} else if (edad.getMonths() == 11) {
					System.out.println("¡Felicidades! Tu cumpleaños se acerca...");						
				}
			} catch (DateTimeParseException e) {
				System.err.println(String.format(
						"La fecha indicada ('%s') no sigue el patrón esperado ('%s').", 
						fechaLeida, PATRON)); 
			}
		}
	}

}
