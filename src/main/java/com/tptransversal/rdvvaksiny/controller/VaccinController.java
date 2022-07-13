package com.tptransversal.rdvvaksiny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tptransversal.rdvvaksiny.model.Docs;
import com.tptransversal.rdvvaksiny.model.Vaccin;
import com.tptransversal.rdvvaksiny.model.VaccinAndMaladie;
import com.tptransversal.rdvvaksiny.model.VaccinView;
import com.tptransversal.rdvvaksiny.service.VaccinService;
import com.tptransversal.rdvvaksiny.service.VaccinViewService;

@RestController
@RequestMapping(value = "/rdvvaksiny/vaccin")
@CrossOrigin(origins = {"*"})
@Component
public class VaccinController {
	
	@Autowired
	VaccinService vaccinService;
	
	@Autowired
	VaccinViewService vaccinViewService;
	
	@PostMapping(value = "/insertion-vaccin", consumes={"application/json"})
	public String insertionVaccin(@RequestBody VaccinAndMaladie vaccinAndMaladie) throws Exception {
		return vaccinService.ajouterUneNouvelleVaccin(vaccinAndMaladie);
	}
	@GetMapping(value = "/list/{limit}/{page}")
	public Docs<Vaccin> liste(@PathVariable int limit,@PathVariable int page){
		return vaccinService.getPageableVaccin(limit,page);
	}
	@GetMapping(value = "/delete-vaccin/{idvaccin}")
	public String delete(@PathVariable int idvaccin){
		return vaccinService.supprimervaccin(idvaccin);
	}
	@GetMapping(value = "/search/{limit}/{page}/{libeller}")
	public Docs<Vaccin> search(@PathVariable int limit,@PathVariable int page,@PathVariable String libeller){
		return vaccinService.getPageableVaccinSearch(limit,page,libeller);
	}
	@GetMapping(value = "/vaccinview/{limit}/{page}")
	public Docs<VaccinView> listeview(@PathVariable int limit,@PathVariable int page){
		return vaccinViewService.getPageableVaccinView(limit,page);
	}
	@GetMapping(value = "/vaccinviewsearch/{limit}/{page}/{libeller}")
	public Docs<VaccinView> vaccinviewsearch(@PathVariable int limit,@PathVariable int page,@PathVariable String libeller){
		return vaccinViewService.getPageableVaccinViewSearch(limit,page,libeller);
	}
	
}
