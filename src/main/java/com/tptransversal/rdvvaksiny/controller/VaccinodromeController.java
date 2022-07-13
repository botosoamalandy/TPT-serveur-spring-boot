package com.tptransversal.rdvvaksiny.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tptransversal.rdvvaksiny.model.Vaccinodrome;
import com.tptransversal.rdvvaksiny.model.VaccinodromeAndHoraire;
import com.tptransversal.rdvvaksiny.service.VaccinodromeService;

@RestController
@RequestMapping(value = "/rdvvaksiny/vaccinodrome")
@CrossOrigin(origins = {"*"})
@Component
public class VaccinodromeController {
	
	@Autowired
	private VaccinodromeService vaccinodromeService;
	
	@PostMapping(value = "/inscription-vaccinodrome", consumes={"application/json"})
	public String inscriptionVaccinodrome(@RequestBody VaccinodromeAndHoraire vaccinodromeAndHoraire) throws Exception {
		return vaccinodromeService.inscriptionVaccinodrome(vaccinodromeAndHoraire);
	}
	@PostMapping(value = "/login-vaccinodrome")
	public String loginVaccinodrome(@RequestBody HashMap<String,String> data) throws Exception{
		return vaccinodromeService.loginVaccinodrome(data.get("email").toString(),data.get("mdp").toString(),data.get("status").toString());
	}
	@PostMapping(value = "/mot-de-passe-oublie")
	public String motDePasseOublie(@RequestBody Vaccinodrome vaccinodrome) throws Exception{
		return vaccinodromeService.motDePasseOublie(vaccinodrome);
	}

}
