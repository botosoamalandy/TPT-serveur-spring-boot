package com.tptransversal.rdvvaksiny.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tptransversal.rdvvaksiny.Repository.CormobiditeRep;
import com.tptransversal.rdvvaksiny.Repository.VaccinRep;
import com.tptransversal.rdvvaksiny.autre.Json;
import com.tptransversal.rdvvaksiny.autre.Utile;
import com.tptransversal.rdvvaksiny.model.Cormobidite;
import com.tptransversal.rdvvaksiny.model.Docs;
import com.tptransversal.rdvvaksiny.model.Maladie;
import com.tptransversal.rdvvaksiny.model.Vaccin;
import com.tptransversal.rdvvaksiny.model.VaccinAndMaladie;

@Service
public class VaccinService {
	
	@Autowired
	VaccinRep vaccinRep;
	@Autowired
	CormobiditeRep cormobiditeRep;
	Utile utile = new Utile();
	
	public boolean getVerifVaccin(Vaccin vaccin) {
		if(utile.verifString(vaccin.getNomVaccin()) && utile.verifString(vaccin.getUrlPhoto())) {
			return true;
		}
		return false;
	}
	public boolean getVerifMaladies(List<Maladie> maladies) {
		int size = maladies.size();
		if(size>0) {
			boolean test = true; 
			for (int i = 0; i < size; i++) {
				if(!utile.verifString(""+maladies.get(i).getIdMaladie())) {
					test = false; break;
				}
			}
			return test;
		}
		return false;
	}
	public boolean getVerifDedoublementVaccin(String nomvaccin) {
		List<Vaccin> vaccins= vaccinRep.findByNomVaccin(nomvaccin.toLowerCase());
		int size = vaccins.size();
		for (int i = 0; i < size; i++) {
			if(vaccins.get(i).getNomVaccin().equalsIgnoreCase(nomvaccin) && vaccins.get(i).getStatus()==1) {
				return true;
			}
		}
		return false;
	}
	@Transactional
	public String ajouterUneNouvelleVaccin(VaccinAndMaladie vaccinAndMaladie) {
		Json json =new Json();
		Vaccin vaccin = vaccinAndMaladie.getVaccin(); List<Maladie> maladies = vaccinAndMaladie.getMaladies();
		if(getVerifVaccin(vaccin) && getVerifMaladies(maladies)) {
			try {
				if(!getVerifDedoublementVaccin(vaccin.getNomVaccin())) {
					int size = maladies.size();List<Cormobidite> cormobidites =new ArrayList<Cormobidite>();vaccin.setStatus(1);
					int idVaccin = vaccinRep.save(vaccin).getIdVaccin();
					System.out.println("size === "+size);
					for (int i = 0; i < size; i++) {
						cormobidites.add(new Cormobidite(1, idVaccin, maladies.get(i).getIdMaladie(), 1));
					}
					cormobiditeRep.saveAll(cormobidites);
					json.put("status",200);
					json.put("message","ajout d'une nouvelle vaccin réussie.");
					return json.toString();
				}else {
					json.put("status",400);
					json.put("message","Cette information existe déjà.");
					return json.toString();
				}
				
			} catch (Exception e) {
				json.put("status",400);
				json.put("message","Erreur : "+e.getMessage());
				return json.toString();
			}
		}
		json.put("status",400);
		json.put("message","Les informations sont incomplètes, merci de compléter tous les champs.");
		return json.toString();
	}
	public Docs<Vaccin> getPageableVaccin(int limit,int pageNumber) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<Vaccin> page = vaccinRep.findByStatusSort(PageRequest.of(pageNumber, limit, Direction.ASC,"nom_vaccin"));
				Docs<Vaccin> docs = new Docs<Vaccin>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		Docs<Vaccin> docs = new Docs<Vaccin>();docs.setDocs(new ArrayList<Vaccin>());
		return docs;
		
	}
	public Docs<Vaccin> getPageableVaccinSearch(int limit,int pageNumber,String libeller) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<Vaccin> page = vaccinRep.findByNom_vaccinSort(libeller.toLowerCase(),PageRequest.of(pageNumber, limit, Direction.ASC,"nom_vaccin"));
				Docs<Vaccin> docs = new Docs<Vaccin>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Docs<Vaccin> docs = new Docs<Vaccin>();docs.setDocs(new ArrayList<Vaccin>());
		return docs;
		
	}
	public String supprimervaccin(int idvaccin) {
		Json json =new Json();
		if(idvaccin>0) {
			try {
				System.out.println("idvaccin = "+idvaccin);
				Vaccin vaccin = vaccinRep.findByIdVaccin(idvaccin);
				if(vaccin!=null) {
					vaccin.setStatus(0);
					vaccinRep.save(vaccin);
					json.put("status",200);
					json.put("message","Le suppression du vaccin a réussie.");
					return json.toString();
				}else {
					json.put("status",400);
					json.put("message","Il y a une erreur d'information.");
					return json.toString();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				json.put("status",400);
				json.put("message","Erreur : "+e.getMessage());
				return json.toString();
			}
		}
		json.put("status",400);
		json.put("message","Les informations sont incomplètes");
		return json.toString();
	}
}
