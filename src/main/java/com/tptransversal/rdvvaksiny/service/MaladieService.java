package com.tptransversal.rdvvaksiny.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tptransversal.rdvvaksiny.Repository.MaladieRep;
import com.tptransversal.rdvvaksiny.autre.Json;
import com.tptransversal.rdvvaksiny.autre.Utile;
import com.tptransversal.rdvvaksiny.model.Docs;
import com.tptransversal.rdvvaksiny.model.Maladie;

@Service
public class MaladieService {
	
	@Autowired
	MaladieRep maladieRep;
	Utile utile = new Utile();
	
	public boolean getVerifDataMaladie(Maladie maladie) {
		if(utile.verifString(maladie.getMaladie()) && utile.verifString(maladie.getDescriptions())) {
			return true;
		}
		return false;
	}
	public boolean getVerifDedoublementMaladie(Maladie maladie) {
		try {
			List<Maladie> maladies = maladieRep.findByMaladie(maladie.getMaladie());int size = maladies.size();
			for (int i = 0; i < size; i++) {
				String nomMaladie = utile.supprimerLesEspace(maladies.get(i).getMaladie()), nomTmp = utile.supprimerLesEspace(maladie.getMaladie());
				if(nomMaladie.equalsIgnoreCase(nomTmp) && maladies.get(i).getStatus()==1) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public Docs<Maladie> getPageableMaladie(int limit,int pageNumber) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<Maladie> page = maladieRep.findByStatusSort(PageRequest.of(pageNumber, limit, Direction.ASC,"maladie"));
				Docs<Maladie> docs = new Docs<Maladie>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Docs<Maladie> docs = new Docs<Maladie>();docs.setDocs(new ArrayList<Maladie>());
		return docs;
		
	}
	public Docs<Maladie> getPageableMaladieByIdVaccin(int idvaccin,int limit,int pageNumber) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<Maladie> page = maladieRep.findByIdVaccinSort(idvaccin,PageRequest.of(pageNumber, limit, Direction.ASC,"maladie"));
				Docs<Maladie> docs = new Docs<Maladie>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Docs<Maladie> docs = new Docs<Maladie>();docs.setDocs(new ArrayList<Maladie>());
		return docs;
		
	}
	public Docs<Maladie> getPageableMaladieSearch(int limit,int pageNumber,String libeller) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<Maladie> page = maladieRep.findByMaladieSort(libeller.toLowerCase(),PageRequest.of(pageNumber, limit, Direction.ASC,"maladie"));
				Docs<Maladie> docs = new Docs<Maladie>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Docs<Maladie> docs = new Docs<Maladie>();docs.setDocs(new ArrayList<Maladie>());
		return docs;
		
	}
	public String ajouterUneNouvelleMaladie(Maladie maladie) {
		Json json =new Json();
		if(getVerifDataMaladie(maladie)) {
			if(!getVerifDedoublementMaladie(maladie)) {
				try {
					maladie.setStatus(1);
					maladieRep.save(maladie);
					json.put("status",200);
					json.put("message","insertion d'une nouvelle maladie réussie ");
					return json.toString();
				} catch (Exception e) {
					json.put("status",400);
					json.put("message","Erreur : "+e.getMessage());
					return json.toString();
				}
			}else {
				json.put("status",400);
				json.put("message","Cet informartion existe déjà");
				return json.toString();
			}
		}
		json.put("status",400);
		json.put("message","Les informations sont incomplètes, merci de compléter tous les champs.");
		return json.toString();
	}
	public String supprimerMaladie(int idmaladie) {
		Json json =new Json();
		if(idmaladie>0) {
			try {
				Maladie maladie = maladieRep.findByIdMaladie(idmaladie);
				if(maladie!=null) {
					maladie.setStatus(0);
					maladieRep.save(maladie);
					json.put("status",200);
					json.put("message","La suppression d'une maladie a réussie.");
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
	public String generaterWarningInInscriptionPatientByMaladie(int idvaccin) {
		String libeller = "";
		try {
			List<Maladie> maladies = maladieRep.findByIdVaccin(idvaccin);int size = maladies.size();
			for (int i = 0; i < size; i++) {
				libeller = libeller + " "+ maladies.get(i).getMaladie();
				if(i< (size-1)) {
					libeller = libeller + ", ";
				}
			}
			libeller = libeller+", ... ";
		} catch (Exception e) {
			e.printStackTrace();
			libeller = "";
		}
		Json json =new Json();
		if(utile.verifString(libeller)) { json.put("status",200); }else { json.put("status",400); }
		json.put("message",libeller);
		return json.toString();
	}

}
