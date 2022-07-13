package com.tptransversal.rdvvaksiny.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tptransversal.rdvvaksiny.Repository.VaccinCentreRep;
import com.tptransversal.rdvvaksiny.autre.Json;
import com.tptransversal.rdvvaksiny.autre.Utile;
import com.tptransversal.rdvvaksiny.model.VaccinCentre;

@Service
public class VaccinCentreService {
	@Autowired
	VaccinCentreRep vaccinCentreRep;
	Utile utile =new Utile();
	
	public boolean getVerifVaccinCentre(VaccinCentre vaccinCentre) {
		if(vaccinCentre.getIdVaccinodrome()>0 && vaccinCentre.getIdVaccin()>0 && vaccinCentre.getQuantite()>=0 && vaccinCentre.getNombreDose() >0
				&& vaccinCentre.getAgeMinimum() > 0) {
			return true;
		}
		return false;
	}
	public boolean getVerifDedoublementVaccinCentre(VaccinCentre vaccinCentre) {
		try {
			List<VaccinCentre> list = vaccinCentreRep.findByIdvaccinodromeAndIdvaccin(vaccinCentre.getIdVaccinodrome(),vaccinCentre.getIdVaccin());
			if(list.size()>0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public String ajouterUneNouvelleVaccinCentre(VaccinCentre vaccinCentre) {
		Json json =new Json();
		if(getVerifVaccinCentre(vaccinCentre)) {
			try {
				if(!getVerifDedoublementVaccinCentre(vaccinCentre)) {
					vaccinCentre.setStatus(1);
					vaccinCentreRep.save(vaccinCentre);
					json.put("status",200);
					json.put("message","ajout d'une nouvelle vaccin dans le centre de vaccination  réussie.");
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
	public String modificationUneNouvelleVaccinCentre(VaccinCentre vaccinCentre) {
		Json json =new Json();
		if(getVerifVaccinCentre(vaccinCentre)) {
			try {
				vaccinCentre.setStatus(1);
				vaccinCentreRep.save(vaccinCentre);
				json.put("status",200);
				json.put("message","La modification du vaccin dans le centre de vaccination a réussie.");
				return json.toString();
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
	public String supprimerUneVaccinCentre(int idvaccincentre) {
		Json json =new Json();
		if(idvaccincentre>0) {
			try {
				VaccinCentre vaccinCentre = new VaccinCentre();vaccinCentre.setIdVaccincentre(idvaccincentre);
				vaccinCentreRep.delete(vaccinCentre);
				json.put("status",200);
				json.put("message","Le suppression du vaccin dans le centre de vaccination a réussie.");
				return json.toString();
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
