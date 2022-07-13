package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="maladie")
public class Maladie {
	@Id
   	@GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "maladie-sequence"
	)
   	@SequenceGenerator(
		name = "maladie-sequence",
		sequenceName = "seq_maladie",
		allocationSize = 1,
		initialValue = 2
	)
   	@Column(name="idmaladie")
   	int idMaladie;
   	@Column(name="maladie")
   	String maladie;
   	@Column(name="descriptions")
   	String descriptions;
   	@Column(name="status")
   	int status;
   
   	public Maladie() {}

	public Maladie(int idMaladie, String maladie, String descriptions, int status) {
		super();
		this.idMaladie = idMaladie;
		this.maladie = maladie;
		this.descriptions = descriptions;
		this.status = status;
	}
	
	public int getIdMaladie() {
		return idMaladie;
	}
	
	public void setIdMaladie(int idMaladie) {
		this.idMaladie = idMaladie;
	}
	
	public String getMaladie() {
		return maladie;
	}
	
	public void setMaladie(String maladie) {
		this.maladie = maladie;
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
