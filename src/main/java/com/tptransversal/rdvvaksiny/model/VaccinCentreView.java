package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaccincentreview")
public class VaccinCentreView {
	@Id
	@Column(name="idvaccincentre")
	int idVaccinCentre;
	@Column(name="idvaccinodrome")
	int idVaccinodrome;
	@Column(name="idvaccin")
	int idVaccin;
	@Column(name="nom_vaccin")
	String nomVaccin;
	@Column(name="url_photo")
	String urlPhoto;
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
	@Column(name="nom_centre")
	String nomCentre;
	@Column(name="localisation")
	String localisation;
	@Column(name="email")
	String email;
	@Column(name="telephone")
	String telephone;
	@Column(name="adresse")
	String adresse;
	@Column(name="imgvaccinodrome")
	String imgvaccinodrome;
	
	public VaccinCentreView() {}

	public VaccinCentreView(int idVaccinCentre, int idVaccinodrome, int idVaccin, String nomVaccin, String urlPhoto,double quantite, int nombreDose, int ageMinimum, String descriptions, int status, String nomCentre,String localisation, String email, String telephone, String adresse, String imgvaccinodrome) {
		this.idVaccinCentre = idVaccinCentre;
		this.idVaccinodrome = idVaccinodrome;
		this.idVaccin = idVaccin;
		this.nomVaccin = nomVaccin;
		this.urlPhoto = urlPhoto;
		this.quantite = quantite;
		this.nombreDose = nombreDose;
		this.ageMinimum = ageMinimum;
		this.descriptions = descriptions;
		this.status = status;
		this.nomCentre = nomCentre;
		this.localisation = localisation;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.imgvaccinodrome = imgvaccinodrome;
	}

	public int getIdVaccinCentre() {
		return idVaccinCentre;
	}

	public void setIdVaccinCentre(int idVaccinCentre) {
		this.idVaccinCentre = idVaccinCentre;
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

	public String getNomVaccin() {
		return nomVaccin;
	}

	public void setNomVaccin(String nomVaccin) {
		this.nomVaccin = nomVaccin;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
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

	public String getNomCentre() {
		return nomCentre;
	}

	public void setNomCentre(String nomCentre) {
		this.nomCentre = nomCentre;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getImgvaccinodrome() {
		return imgvaccinodrome;
	}

	public void setImgvaccinodrome(String imgvaccinodrome) {
		this.imgvaccinodrome = imgvaccinodrome;
	}

	
	
}
