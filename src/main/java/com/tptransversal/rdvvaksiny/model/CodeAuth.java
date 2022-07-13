package com.tptransversal.rdvvaksiny.model;

public class CodeAuth {
	int patient = 100;
    int vaccinodrome = 250;
    int administrateur = 475;
    
    public CodeAuth() {}

	public CodeAuth(int patient, int vaccinodrome, int administrateur) {
		this.patient = patient;
		this.vaccinodrome = vaccinodrome;
		this.administrateur = administrateur;
	}

	public int getPatient() {
		return patient;
	}

	public void setPatient(int patient) {
		this.patient = patient;
	}

	public int getVaccinodrome() {
		return vaccinodrome;
	}

	public void setVaccinodrome(int vaccinodrome) {
		this.vaccinodrome = vaccinodrome;
	}

	public int getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(int administrateur) {
		this.administrateur = administrateur;
	}
    
    
}
