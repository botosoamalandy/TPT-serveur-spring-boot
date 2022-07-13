package com.tptransversal.rdvvaksiny.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
	@Id
   @GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "utilisateur-sequence"
	)
   @SequenceGenerator(
		name = "utilisateur-sequence",
		sequenceName = "seq_utilisateur",
		allocationSize = 1,
		initialValue = 2
	)
	@Column(name="idutilisateur")
	int idutilisateur;
	@Column(name="idtypeutilisateur")
	int idtypeutilisateur;
	@Column(name="nom")
	String nom;
	@Column(name="sexe")
	 int sexe;
	@Column(name="naissance")
	Date naissance;
	@Column(name="email")
	String email;
	@Column(name="telephone")
	String telephone;
	@Column(name="mot_de_passe")
	String mot_de_passe;
	@Column(name="url_photo")
	String urlPhoto;
	@Column(name="date_ajout")
	Date date_ajout;
	@Column(name="status")
	int status;
	
	public Utilisateur() {}
	
	public Utilisateur(int idutilisateur, int idtypeutilisateur, String nom, int sexe, Date naissance,String email, String telephone,String mot_de_passe,String urlPhoto, Date date_ajout, int status) {
		this.idutilisateur = idutilisateur;
		this.idtypeutilisateur = idtypeutilisateur;
		this.nom = nom;
		this.sexe = sexe;
		this.naissance = naissance;
		this.email = email;
		this.telephone = telephone;
		this.mot_de_passe = mot_de_passe;
		this.urlPhoto = urlPhoto;
		this.date_ajout = date_ajout;
		this.status = status;
	}
	
	public int getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(int idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public Date getDate_ajout() {
		return date_ajout;
	}

	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}

	public int getIdtypeutilisateur() {
		return idtypeutilisateur;
	}

	public void setIdtypeutilisateur(int idtypeutilisateur) {
		this.idtypeutilisateur = idtypeutilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getSexe() {
		return sexe;
	}
	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	public Date getNaissance() {
		return naissance;
	}
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	
	
}
