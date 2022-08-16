package es.dsrroma.school.java.desafio1.video01_03;

import java.util.ArrayList;
import java.util.List;

public class TableroBingo {
	private List<ColumnaBingo> columnas = new ArrayList<>();
	
	public TableroBingo() {
		for (LetraBingo letra : LetraBingo.values()) {
			columnas.add(new ColumnaBingo(letra));
		}	
	}
	
	@Override
	public String toString() {
		String s = "";
		for (ColumnaBingo columnaBingo : columnas) {
			s += columnaBingo.toString() + "\n";
		}
		return s;
	}
	
	
}
