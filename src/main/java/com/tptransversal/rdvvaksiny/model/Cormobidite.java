package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cormobidite")
public class Cormobidite {
   @Id
   @GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "cormobidite-sequence"
	)
   @SequenceGenerator(
		name = "cormobidite-sequence",
		sequenceName = "seq_cormobidite",
		allocationSize = 1,
		initialValue = 2
	)
   @Column(name="idcormobidite")
   int idCormobidite;
   @Column(name="idvaccin")
   int idVaccin;
   @Column(name="idmaladie")
   int idMaladie;
   @Column(name="status")
   int status;
   
   public Cormobidite() {}

	public Cormobidite(int idCormobidite, int idVaccin, int idMaladie, int status) {
		this.idCormobidite = idCormobidite;
		this.idVaccin = idVaccin;
		this.idMaladie = idMaladie;
		this.status = status;
	}
	
	public int getIdCormobidite() {
		return idCormobidite;
	}
	
	public void setIdCormobidite(int idCormobidite) {
		this.idCormobidite = idCormobidite;
	}
	
	public int getIdVaccin() {
		return idVaccin;
	}
	
	public void setIdVaccin(int idVaccin) {
		this.idVaccin = idVaccin;
	}
		
	public int getIdMaladie() {
		return idMaladie;
	}

	public void setIdMaladie(int idMaladie) {
		this.idMaladie = idMaladie;
	}	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
   
   
}
