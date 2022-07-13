package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vaccincentre")
public class VaccinCentre {
   @Id
   @GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "vaccincentre-sequence"
	)
   @SequenceGenerator(
		name = "vaccincentre-sequence",
		sequenceName = "seq_vaccincentre",
		allocationSize = 1,
		initialValue = 2
	)
	@Column(name="idvaccincentre")
	int idVaccincentre;
	@Column(name="idvaccinodrome")
    int idVaccinodrome;
	@Column(name="idvaccin")
    int idVaccin;
	@Column(name="quantite")
	double quantite;
	@Column(name="nombre_dose")
    int nombreDose;
	@Column(name="age_minimum")
    int ageMinimum;
	@Column(name="descriptions")
    String descriptions;
	@Column(name="status")
    int status;
	
	public VaccinCentre() {}
	
	public VaccinCentre(int idVaccincentre, int idVaccinodrome, int idVaccin, double quantite, int nombreDose,int ageMinimum, String descriptions, int status) {
		this.idVaccincentre = idVaccincentre;
		this.idVaccinodrome = idVaccinodrome;
		this.idVaccin = idVaccin;
		this.quantite = quantite;
		this.nombreDose = nombreDose;
		this.ageMinimum = ageMinimum;
		this.descriptions = descriptions;
		this.status = status;
	}

	public int getIdVaccincentre() {
		return idVaccincentre;
	}
	public void setIdVaccincentre(int idVaccincentre) {
		this.idVaccincentre = idVaccincentre;
	}
	public int getIdVaccinodrome() {
		return idVaccinodrome;
	}
	public void setIdVaccinodrome(int idVaccinodrome) {
		this.idVaccinodrome = idVaccinodrome;
	}
	public int getIdVaccin() {
		return idVaccin;
	}
	public void setIdVaccin(int idVaccin) {
		this.idVaccin = idVaccin;
	}
	
	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public int getNombreDose() {
		return nombreDose;
	}
	public void setNombreDose(int nombreDose) {
		this.nombreDose = nombreDose;
	}
	public int getAgeMinimum() {
		return ageMinimum;
	}
	public void setAgeMinimum(int ageMinimum) {
		this.ageMinimum = ageMinimum;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
