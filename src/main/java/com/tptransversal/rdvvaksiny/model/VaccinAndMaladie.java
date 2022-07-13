package com.tptransversal.rdvvaksiny.model;

import java.util.ArrayList;
import java.util.List;

public class VaccinAndMaladie {
	Vaccin vaccin = new Vaccin();
	List<Maladie> maladies =new ArrayList<Maladie>();
	
	public VaccinAndMaladie() {}

	public VaccinAndMaladie(Vaccin vaccin, List<Maladie> maladies) {
		this.vaccin = vaccin;
		this.maladies = maladies;
	}

	public Vaccin getVaccin() {
		return vaccin;
	}

	public void setVaccin(Vaccin vaccin) {
		this.vaccin = vaccin;
	}

	public List<Maladie> getMaladies() {
		return maladies;
	}

	public void setMaladies(List<Maladie> maladies) {
		this.maladies = maladies;
	}
	
	
	
	
}	
