package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaccinview")
public class VaccinView {
	@Id
	@Column(name="idvaccin")
	int idVaccin;
	@Column(name="nom_vaccin")
	String nomVaccin;
	@Column(name="url_photo")
	String urlPhoto;
	@Column(name="descriptions")
	String descriptions;
	@Column(name="maladie")
	String maladie;
	@Column(name="status")
	int status;
	
	public VaccinView() {}
	
	public VaccinView(int idVaccin, String nomVaccin, String urlPhoto, String descriptions, String maladie,int status) {
		this.idVaccin = idVaccin;
		this.nomVaccin = nomVaccin;
		this.urlPhoto = urlPhoto;
		this.descriptions = descriptions;
		this.maladie = maladie;
		this.status = status;
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

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getMaladie() {
		return maladie;
	}

	public void setMaladie(String maladie) {
		this.maladie = maladie;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
