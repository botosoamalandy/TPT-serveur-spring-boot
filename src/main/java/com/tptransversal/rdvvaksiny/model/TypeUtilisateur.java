package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="typeutilisateur")
@SuppressWarnings("unused")
public class TypeUtilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idtypeutilisateur;
	private String libeller;
	private Integer status;
	
	public TypeUtilisateur() {}

	public TypeUtilisateur(Integer idtypeutilisateur, String libeller, Integer status) {
		this.idtypeutilisateur = idtypeutilisateur;
		this.libeller = libeller;
		this.status = status;
	}

	public Integer getIdtypeutilisateur() {
		return idtypeutilisateur;
	}

	public void setIdtypeutilisateur(Integer idtypeutilisateur) {
		this.idtypeutilisateur = idtypeutilisateur;
	}

	public String getLibeller() {
		return libeller;
	}

	public void setLibeller(String libeller) {
		this.libeller = libeller;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
