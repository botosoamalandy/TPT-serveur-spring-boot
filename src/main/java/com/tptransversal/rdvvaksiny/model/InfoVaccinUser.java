package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="infovaccinuser")
public class InfoVaccinUser {
   @Id
   @GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "infovaccinuser-sequence"
   )
   @SequenceGenerator(
		name = "infovaccinuser-sequence",
		sequenceName = "seq_infovaccinuser",
		allocationSize = 1,
		initialValue = 2
   )
   @Column(name="idinfovaccinuser")
   int idInfoVaccinUser;
   @Column(name="idutilisateur")
   int idUtilisateur;
   @Column(name="idvaccincentre")
   int idVaccinCentre;
   @Column(name="idvaccinodrome")
   int idVaccinodrome;
   @Column(name="idvaccin")
   int idVaccin;
   @Column(name="status")
   int status;
   
   public InfoVaccinUser() {}

	public InfoVaccinUser(int idInfoVaccinUser, int idUtilisateur, int idVaccinCentre, int idVaccinodrome, int idVaccin,int status) {
		this.idInfoVaccinUser = idInfoVaccinUser;
		this.idUtilisateur = idUtilisateur;
		this.idVaccinCentre = idVaccinCentre;
		this.idVaccinodrome = idVaccinodrome;
		this.idVaccin = idVaccin;
		this.status = status;
	}
	
	public int getIdInfoVaccinUser() {
		return idInfoVaccinUser;
	}
	
	public void setIdInfoVaccinUser(int idInfoVaccinUser) {
		this.idInfoVaccinUser = idInfoVaccinUser;
	}
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
   
}
