package es.dsrroma.school.java.desafio1.video01_18;

import java.time.LocalDateTime;

public class EsHoraDePlanchar {
	
	public static Tarifa esHoraDePlanchar(LocalDateTime momento) {
		return switch(momento.getDayOfWeek()) {
			case SATURDAY, SUNDAY -> Tarifa.VALLE;
			default -> tarifaSegunHora(momento);
		};
	}

	private static Tarifa tarifaSegunHora(LocalDateTime momento) {
		int hora = momento.getHour();
		if (hora < 8) {
			return Tarifa.VALLE;
		} else if ((hora >= 10 && hora < 14) || 
				(hora >= 18 && hora < 22)) {
			return Tarifa.PUNTA;
		} else {
			return Tarifa.LLANO;
		}
	}

	public static void main(String[] args) {
		LocalDateTime ahora = LocalDateTime.now();
		System.out.println(esHoraDePlanchar(ahora));
		
		for (int i = 0; i < 24; i ++) {
			System.out.println(i + "h: " 
				+ esHoraDePlanchar(LocalDateTime.now().withHour(i)));
		}
		for (int i = 0; i < 7; i ++) {
			LocalDateTime dia = LocalDateTime.now().minusDays(i);
			System.out.println(dia.getDayOfWeek() + ": " 
				+ esHoraDePlanchar(dia));
		}
	}

}
