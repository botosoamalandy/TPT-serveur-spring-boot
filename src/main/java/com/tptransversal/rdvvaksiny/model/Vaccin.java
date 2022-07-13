package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vaccin")
public class Vaccin {
	
   @Id
   @GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "vaccin-sequence"
	)
   @SequenceGenerator(
		name = "vaccin-sequence",
		sequenceName = "seq_vaccin",
		allocationSize = 1,
		initialValue = 2
	)
	@Column(name="idvaccin")
	int idVaccin;
    @Column(name="nom_vaccin")
    String nomVaccin;
    @Column(name="url_photo")
    String urlPhoto;
    @Column(name="descriptions")
    String descriptions;
    @Column(name="status")
    int status;
   
   	public Vaccin() {}
   
	public Vaccin(int idVaccin, String nomVaccin, String urlPhoto, String descriptions, int status) {
		this.idVaccin = idVaccin;
		this.nomVaccin = nomVaccin;
		this.urlPhoto = urlPhoto;
		this.descriptions = descriptions;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
   
   
}
