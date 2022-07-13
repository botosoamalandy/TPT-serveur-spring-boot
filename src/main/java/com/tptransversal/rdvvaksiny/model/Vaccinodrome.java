package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="vaccinodrome")
public class Vaccinodrome {
	@Id
    @GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "vaccinodrome-sequence"
	)
    @SequenceGenerator(
		name = "vaccinodrome-sequence",
		sequenceName = "seq_vaccinodrome",
		allocationSize = 1,
		initialValue = 2
	)
	@Column(name="idvaccinodrome")
	int idVaccinodrome;
	@Column(name="idregion")
	String idRegion;
	@Column(name="iddistrict")
	String idDistrict;
	@Column(name="idcommune")
	String idCommune;
	@Column(name="idarrindissement")
	String idArrindissement;
	@Column(name="idfokontany")
    String idFokontany;
	@Column(name="localisation")
	String localisation;
	@Column(name="nom_centre")
    String nomCentre;
	@Column(name="email")
    String email;
	@Column(name="telephone")
    String telephone;
	@Column(name="adresse")
    String adresse;
	@Column(name="descriptions")
    String descriptions;
	@Column(name="url_photo")
    String urlPhoto;
	@Column(name="mot_de_passe")
    String motDePasse;
	@Column(name="status")
    int status;
	
	public Vaccinodrome() {}

	public Vaccinodrome(int idVaccinodrome, String idRegion, String idDistrict, String idCommune,String idArrindissement, String idFokontany,String localisation, String nomCentre, String email, String telephone,String adresse, String descriptions, String urlPhoto, String motDePasse, int status) {
		this.idVaccinodrome = idVaccinodrome;
		this.idRegion = idRegion;
		this.idDistrict = idDistrict;
		this.idCommune = idCommune;
		this.idArrindissement = idArrindissement;
		this.idFokontany = idFokontany;
		this.localisation = localisation;
		this.nomCentre = nomCentre;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.descriptions = descriptions;
		this.urlPhoto = urlPhoto;
		this.motDePasse = motDePasse;
		this.status = status;
	}

	public int getIdVaccinodrome() {
		return idVaccinodrome;
	}

	public void setIdVaccinodrome(int idVaccinodrome) {
		this.idVaccinodrome = idVaccinodrome;
	}

	public String getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}

	public String getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(String idDistrict) {
		this.idDistrict = idDistrict;
	}

	public String getIdCommune() {
		return idCommune;
	}

	public void setIdCommune(String idCommune) {
		this.idCommune = idCommune;
	}

	public String getIdArrindissement() {
		return idArrindissement;
	}

	public void setIdArrindissement(String idArrindissement) {
		this.idArrindissement = idArrindissement;
	}

	public String getIdFokontany() {
		return idFokontany;
	}

	public void setIdFokontany(String idFokontany) {
		this.idFokontany = idFokontany;
	}
	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getNomCentre() {
		return nomCentre;
	}

	public void setNomCentre(String nomCentre) {
		this.nomCentre = nomCentre;
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

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
