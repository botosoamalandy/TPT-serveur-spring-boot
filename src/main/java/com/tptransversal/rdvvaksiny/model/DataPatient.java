package com.tptransversal.rdvvaksiny.model;

public class DataPatient {
	Utilisateur utilisateur = new Utilisateur();
	InfoVaccinUser infoVaccinUser = new InfoVaccinUser();
	
	public DataPatient() {}

	public DataPatient(Utilisateur utilisateur, InfoVaccinUser infoVaccinUser) {
		this.utilisateur = utilisateur;
		this.infoVaccinUser = infoVaccinUser;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public InfoVaccinUser getInfoVaccinUser() {
		return infoVaccinUser;
	}

	public void setInfoVaccinUser(InfoVaccinUser infoVaccinUser) {
		this.infoVaccinUser = infoVaccinUser;
	}
	
	
}
