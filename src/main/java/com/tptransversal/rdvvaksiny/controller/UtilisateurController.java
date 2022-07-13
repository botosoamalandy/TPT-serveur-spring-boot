package com.tptransversal.rdvvaksiny.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tptransversal.rdvvaksiny.model.DataPatient;
import com.tptransversal.rdvvaksiny.model.Utilisateur;
import com.tptransversal.rdvvaksiny.service.UtilisateurService;

@RestController
@RequestMapping(value = "/rdvvaksiny/utilisateur")
@CrossOrigin(origins = {"*"})
@Component
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping(value = "/list")
	public List<Utilisateur> liste(){
		return utilisateurService.getAllUtilisateur();
	}
	@PostMapping(value = "/login-utilisateur")
	public String loginadmin(@RequestBody HashMap<String,String> data) throws Exception{
		return utilisateurService.loginUtilisateur(data.get("telephone").toString(), data.get("mot_de_passe").toString(),data.get("status").toString());
	}
	@PostMapping(value = "/inscription-patient", consumes={"application/json"})
	public String insertionVaccin(@RequestBody DataPatient DataPatient) throws Exception {
		return utilisateurService.inscriptionPatient(DataPatient);
	}
	@PostMapping(value = "/mot-de-passe-oublie", consumes={"application/json"})
	public String motDePasseOublie(@RequestBody Utilisateur utilisateur) throws Exception {
		return utilisateurService.mdpOublie(utilisateur);
	}
}
