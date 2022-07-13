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

import com.tptransversal.rdvvaksiny.model.DataSearch;
import com.tptransversal.rdvvaksiny.model.Docs;
import com.tptransversal.rdvvaksiny.model.VaccinCentre;
import com.tptransversal.rdvvaksiny.model.VaccinCentreView;
import com.tptransversal.rdvvaksiny.service.VaccinCentreService;
import com.tptransversal.rdvvaksiny.service.VaccinCentreViewService;

@RestController
@RequestMapping(value = "/rdvvaksiny/vaccincentre")
@CrossOrigin(origins = {"*"})
@Component
public class VaccinCentreController {

	@Autowired
	VaccinCentreService vaccinCentreService;
	
	@Autowired
	VaccinCentreViewService vaccinCentreViewService;
	
	@PostMapping(value = "/insertion-vaccin-centrevaccination", consumes={"application/json"})
	public String insertionVaccin(@RequestBody VaccinCentre vaccinCentre) throws Exception {
		return vaccinCentreService.ajouterUneNouvelleVaccinCentre(vaccinCentre);
	}
	@PostMapping(value = "/edit-vaccin-centrevaccination", consumes={"application/json"})
	public String editVaccin(@RequestBody VaccinCentre vaccinCentre) throws Exception {
		return vaccinCentreService.modificationUneNouvelleVaccinCentre(vaccinCentre);
	}
	@GetMapping(value = "/delete-vaccincentre/{idvaccincentre}")
	public String delete(@PathVariable int idvaccincentre){
		return vaccinCentreService.supprimerUneVaccinCentre(idvaccincentre);
	}
	@GetMapping(value = "/list/{idvaccinodrome}/{limit}/{page}")
	public Docs<VaccinCentreView> liste(@PathVariable int idvaccinodrome,@PathVariable int limit,@PathVariable int page){
		return vaccinCentreViewService.getPageableVaccinCentreView(idvaccinodrome,limit,page);
	}
	@GetMapping(value = "/search/{idvaccinodrome}/{limit}/{page}/{libeller}")
	public Docs<VaccinCentreView> search(@PathVariable int idvaccinodrome,@PathVariable int limit,@PathVariable int page,@PathVariable String libeller){
		return vaccinCentreViewService.getPageableVaccinVaccinCentreView(idvaccinodrome,limit,page,libeller);
	}
	@GetMapping(value = "/listbyidvaccin/{idvaccin}/{limit}/{page}")
	public Docs<VaccinCentreView> vaccinviewbyidvaccin(@PathVariable int idvaccin,@PathVariable int limit,@PathVariable int page){
		return vaccinCentreViewService.getPageableVaccinCentreViewByIdVaccin(idvaccin,limit,page);
	}
	@GetMapping(value = "/searchbyidvaccin/{idvaccin}/{limit}/{page}/{libeller}")
	public Docs<VaccinCentreView> vaccinviewsearchbyidvaccin(@PathVariable int idvaccin,@PathVariable int limit,@PathVariable int page,@PathVariable String libeller){
		return vaccinCentreViewService.getPageableVaccinVaccinCentreViewByIdVaccin(idvaccin,limit,page,libeller);
	}
	@PostMapping(value = "/searchbyfilter-centrevaccination", consumes={"application/json"})
	public Docs<VaccinCentreView> searchbyfilter(@RequestBody DataSearch dataSearch) throws Exception {
		return vaccinCentreViewService.searchCentreVaccinationByFilter(dataSearch);
	}
}
