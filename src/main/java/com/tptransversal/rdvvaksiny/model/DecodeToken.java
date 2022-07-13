package com.tptransversal.rdvvaksiny.model;

public class DecodeToken {
	
	String iss = "";
	long iat = 0;
	long exp = 0;
	int codeutilisateur = 0;
	String nom = "";
	String email="";
	long expiration = 0;
	
	public DecodeToken() {}
	
	public DecodeToken(String iss, long iat, long exp, int codeutilisateur, String nom, String email, long expiration) {
		this.iss = iss;
		this.iat = iat;
		this.exp = exp;
		this.codeutilisateur = codeutilisateur;
		this.nom = nom;
		this.email = email;
		this.expiration = expiration;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public long getIat() {
		return iat;
	}

	public void setIat(long iat) {
		this.iat = iat;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public int getCodeutilisateur() {
		return codeutilisateur;
	}

	public void setCodeutilisateur(int codeutilisateur) {
		this.codeutilisateur = codeutilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getExpiration() {
		return expiration;
	}

	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}
	
}
