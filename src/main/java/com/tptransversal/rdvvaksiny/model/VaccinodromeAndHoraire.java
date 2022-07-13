package com.tptransversal.rdvvaksiny.model;

import java.util.ArrayList;
import java.util.List;

public class VaccinodromeAndHoraire {
	
	Vaccinodrome vaccinodrome = new Vaccinodrome();
	List<HoraireVaccinodrome> horaireVaccinodromes = new ArrayList<HoraireVaccinodrome>();
	
	public VaccinodromeAndHoraire() {}
	public VaccinodromeAndHoraire(Vaccinodrome vaccinodrome, List<HoraireVaccinodrome> horaireVaccinodromes) {
		this.vaccinodrome = vaccinodrome;
		this.horaireVaccinodromes = horaireVaccinodromes;
	}
	public Vaccinodrome getVaccinodrome() {
		return vaccinodrome;
	}
	public void setVaccinodrome(Vaccinodrome vaccinodrome) {
		this.vaccinodrome = vaccinodrome;
	}
	public List<HoraireVaccinodrome> getHoraireVaccinodromes() {
		return horaireVaccinodromes;
	}
	public void setHoraireVaccinodromes(List<HoraireVaccinodrome> horaireVaccinodromes) {
		this.horaireVaccinodromes = horaireVaccinodromes;
	}
	
	

}
