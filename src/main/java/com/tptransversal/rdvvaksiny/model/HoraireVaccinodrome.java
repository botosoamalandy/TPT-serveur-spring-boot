package com.tptransversal.rdvvaksiny.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="horairevaccinodrome")
public class HoraireVaccinodrome {
	@Id
    @GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "horairevaccinodrome-sequence"
	)
    @SequenceGenerator(
		name = "horairevaccinodrome-sequence",
		sequenceName = "seq_horairevaccinodrome",
		allocationSize = 1,
		initialValue = 2
	)
	@Column(name="idhorairevaccinodrome")
	int idhorairevaccinodrome;
	@Column(name="idvaccinodrome")
    int idvaccinodrome;
    @Column(name="jour")
	int jour;
    @Column(name="matin_debut")
	int matinDebut ;
    @Column(name="matin_fin")
	int matinFin ;
    @Column(name="midi_debut")
	int midiDebut ;
    @Column(name="midi_fin")
	int midiFin;
    @Column(name="status")
	int status;
    
    public HoraireVaccinodrome() {}

	public HoraireVaccinodrome(int idhorairevaccinodrome, int idvaccinodrome, int jour, int matinDebut, int matinFin,int midiDebut, int midiFin, int status) {
		this.idhorairevaccinodrome = idhorairevaccinodrome;
		this.idvaccinodrome = idvaccinodrome;
		this.jour = jour;
		this.matinDebut = matinDebut;
		this.matinFin = matinFin;
		this.midiDebut = midiDebut;
		this.midiFin = midiFin;
		this.status = status;
	}

	public int getIdhorairevaccinodrome() {
		return idhorairevaccinodrome;
	}

	public void setIdhorairevaccinodrome(int idhorairevaccinodrome) {
		this.idhorairevaccinodrome = idhorairevaccinodrome;
	}

	public int getIdvaccinodrome() {
		return idvaccinodrome;
	}

	public void setIdvaccinodrome(int idvaccinodrome) {
		this.idvaccinodrome = idvaccinodrome;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMatinDebut() {
		return matinDebut;
	}

	public void setMatinDebut(int matinDebut) {
		this.matinDebut = matinDebut;
	}

	public int getMatinFin() {
		return matinFin;
	}

	public void setMatinFin(int matinFin) {
		this.matinFin = matinFin;
	}

	public int getMidiDebut() {
		return midiDebut;
	}

	public void setMidiDebut(int midiDebut) {
		this.midiDebut = midiDebut;
	}

	public int getMidiFin() {
		return midiFin;
	}

	public void setMidiFin(int midiFin) {
		this.midiFin = midiFin;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
    
}
