package com.tptransversal.rdvvaksiny.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tptransversal.rdvvaksiny.Repository.InfoVaccinUserRep;
import com.tptransversal.rdvvaksiny.Repository.TypeUtilisateurRep;
import com.tptransversal.rdvvaksiny.Repository.UtilisateurRep;
import com.tptransversal.rdvvaksiny.autre.CryptoConfig;
import com.tptransversal.rdvvaksiny.autre.Json;
import com.tptransversal.rdvvaksiny.autre.Utile;
import com.tptransversal.rdvvaksiny.model.DataPatient;
import com.tptransversal.rdvvaksiny.model.InfoVaccinUser;
import com.tptransversal.rdvvaksiny.model.TypeUtilisateur;
import com.tptransversal.rdvvaksiny.model.Utilisateur;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRep utilisateurRep;
	@Autowired
	private TypeUtilisateurRep typeUtilisateurRep;
	@Autowired
	private InfoVaccinUserRep infoVaccinUserRep;
	Utile utile= new Utile();
	
	public List<Utilisateur> getAllUtilisateur(){
		try {
			return utilisateurRep.findByTelephone("%65%");
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Utilisateur>();
		}
	}
	public String loginUtilisateur(String telephone,String mdp,String status) {
		Json json = new Json();
		if(utile.verifString(telephone) && utile.verifString(mdp)) {
			String tel = utile.supprimerLesEspace(telephone);
			List<Utilisateur> utilisateurs = utilisateurRep.findByTelephone(tel);int size = utilisateurs.size();
			String motdepasse = CryptoConfig.generateSecurePassword(mdp, CryptoConfig.DEFAULT_SALT);int code = utile.setStringToInt(status);
			for (int i = 0; i < size; i++) {
				if(utilisateurs.get(i).getTelephone().equalsIgnoreCase(tel)) {
					if(utilisateurs.get(i).getMot_de_passe().equals(motdepasse)) {
						TypeUtilisateur typeUtilisateur = typeUtilisateurRep.findByIdtypeutilisateur(""+utilisateurs.get(i).getIdtypeutilisateur());
						if(typeUtilisateur!=null) {
							if(typeUtilisateur.getStatus()>0 && code==typeUtilisateur.getStatus()) {
								json.put("token", utile.generateJwtByUser(utilisateurs.get(i),typeUtilisateur.getStatus(),"rdvvaksiny_botosoamalandy_toavina_zo"));
								json.put("message","Connexion autorisée");
								json.put("status",200);
								return json.toString();
							}else {
								json.put("message","Votre code d'authentification est invalide.");
								json.put("status",400);
								return json.toString();
							}
						}
						json.put("message","Il y a une erreur d'information.");
						json.put("status",400);
						return json.toString();
					}
				}
			}
			json.put("message","Votre numéro de téléphone ne correspond à aucun des utilisateurs.");
			json.put("status",400);
			return json.toString();
		}
		json.put("message","Il y a un champ vide");
		json.put("status",400);
		return json.toString();
	}
	public boolean getVerifUtilisateur(Utilisateur utilisateur) {
		if(utile.verifString(utilisateur.getNom()) && utilisateur.getSexe()>=1 && utilisateur.getSexe()<=2 && utilisateur.getNaissance()!=null 
				&& utile.verifString(utilisateur.getEmail()) && utile.verifString(utilisateur.getTelephone()) && utile.verifString(utilisateur.getMot_de_passe()) 
				&& utile.verifString(utilisateur.getUrlPhoto())) {
			return true;
		}
		return false;
	}
	public boolean getVerifInfoVaccinUser(InfoVaccinUser infoVaccinUser) {
		if(infoVaccinUser.getIdVaccinCentre()>0 && infoVaccinUser.getIdVaccinodrome()>0 && infoVaccinUser.getIdVaccin()>0) {
			return true;
		}
		return false;
	}
	public boolean getVerifDedoublementUtilisateur(Utilisateur utilisateur) {
		try {
			String tel = utile.supprimerLesEspace(utilisateur.getTelephone());
			List<Utilisateur> list = utilisateurRep.findByEmailAndTelephone(utilisateur.getEmail(),tel); int size = list.size();
			for (int i = 0; i < size; i++) {
				if(list.get(i).getEmail().equalsIgnoreCase(utilisateur.getEmail()) && list.get(i).getTelephone().equalsIgnoreCase(tel) && list.get(i).getStatus()==1) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	public String inscriptionPatient(DataPatient dataPatient) {
		Json json =new Json();
		Utilisateur utilisateur = dataPatient.getUtilisateur();InfoVaccinUser infoVaccinUser = dataPatient.getInfoVaccinUser();
		if(getVerifInfoVaccinUser(infoVaccinUser) && getVerifUtilisateur(utilisateur)) {
			try {
				if(!getVerifDedoublementUtilisateur(utilisateur)) {
					String motdepasse = CryptoConfig.generateSecurePassword(utilisateur.getMot_de_passe(), CryptoConfig.DEFAULT_SALT);
					utilisateur.setDate_ajout(utile.getDateNow());utilisateur.setStatus(1);utilisateur.setIdtypeutilisateur(1);
					utilisateur.setTelephone(utile.supprimerLesEspace(utilisateur.getTelephone()));utilisateur.setMot_de_passe(motdepasse);
					int idUser = utilisateurRep.save(utilisateur).getIdutilisateur();
					System.out.println("iduser : "+idUser);
					infoVaccinUser.setIdUtilisateur(idUser);infoVaccinUser.setStatus(1);
					infoVaccinUserRep.save(infoVaccinUser);
					json.put("status",200);
					json.put("message","ajout d'une nouvelle patient avec réussie.");
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
	public String mdpOublie(Utilisateur utilisateur) {
		Json json =new Json();
		if(utile.verifString(utilisateur.getTelephone()) && utile.verifString(utilisateur.getEmail()) && utile.verifString(utilisateur.getMot_de_passe())) {
			String tel = utile.supprimerLesEspace(utilisateur.getTelephone());
			List<Utilisateur> list = utilisateurRep.findByTelephone(tel);int size = list.size();
			for (int i = 0; i < size; i++) {
				if(list.get(i).getTelephone().equalsIgnoreCase(tel) && list.get(i).getEmail().equalsIgnoreCase(utilisateur.getEmail())) {
					try {
						String motdepasse = CryptoConfig.generateSecurePassword(utilisateur.getMot_de_passe(), CryptoConfig.DEFAULT_SALT);
						Utilisateur newUtilisateur = list.get(i); newUtilisateur.setMot_de_passe(motdepasse);
						utilisateurRep.save(newUtilisateur);
						json.put("status",200);
						json.put("message","Le mot de passe a été mis à jour");
						return json.toString();
					} catch (Exception e) {
						json.put("status",400);
						json.put("message","Erreur : "+e.getMessage());
						return json.toString();
					}
				}
			}
			json.put("status",400);
			json.put("message","Ce compte n'existe pas.");
			return json.toString();
		}
		json.put("status",400);
		json.put("message","Il y a un champ vide, je vous en prie, remplissez-le.");
		return json.toString();
	}
}
