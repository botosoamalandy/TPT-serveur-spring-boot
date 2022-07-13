package com.tptransversal.rdvvaksiny.service;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tptransversal.rdvvaksiny.Repository.VaccinCentreViewRep;
import com.tptransversal.rdvvaksiny.autre.Utile;
import com.tptransversal.rdvvaksiny.model.DataSearch;
import com.tptransversal.rdvvaksiny.model.Docs;
import com.tptransversal.rdvvaksiny.model.VaccinCentreView;

@Service
public class VaccinCentreViewService {

	@Autowired
	VaccinCentreViewRep vaccinCentreViewRep;
	@PersistenceContext
    private EntityManager entityManager;
	Utile utile =new Utile();
	
	public Docs<VaccinCentreView> getPageableVaccinCentreView(int idvaccinodrome,int limit,int pageNumber) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<VaccinCentreView> page = vaccinCentreViewRep.findByIdVaccinodromeSort(idvaccinodrome,PageRequest.of(pageNumber, limit, Direction.ASC,"nom_vaccin"));
				Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>();docs.setDocs(new ArrayList<VaccinCentreView>());
		return docs;
	}
	public Docs<VaccinCentreView> getPageableVaccinVaccinCentreView(int idvaccinodrome,int limit,int pageNumber,String libeller) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<VaccinCentreView> page = vaccinCentreViewRep.findByIdVaccinodromeAndNom_vaccinSort(idvaccinodrome,libeller.toLowerCase(),PageRequest.of(pageNumber, limit, Direction.ASC,"nom_vaccin"));
				Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>();docs.setDocs(new ArrayList<VaccinCentreView>());
		return docs;
		
	}
	
	public Docs<VaccinCentreView> getPageableVaccinCentreViewByIdVaccin(int idvaccin,int limit,int pageNumber) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<VaccinCentreView> page = vaccinCentreViewRep.findByIdVaccinoSort(idvaccin,PageRequest.of(pageNumber, limit, Direction.ASC,"nom_vaccin"));
				Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>();docs.setDocs(new ArrayList<VaccinCentreView>());
		return docs;
	}
	public Docs<VaccinCentreView> getPageableVaccinVaccinCentreViewByIdVaccin(int idvaccin,int limit,int pageNumber,String libeller) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<VaccinCentreView> page = vaccinCentreViewRep.findByIdVaccinAndNom_vaccinSort(idvaccin,libeller.toLowerCase(),PageRequest.of(pageNumber, limit, Direction.ASC,"nom_vaccin"));
				Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>();docs.setDocs(new ArrayList<VaccinCentreView>());
		return docs;
		
	}
	public Page<VaccinCentreView> getData(int idvaccin,DataSearch dataSearch,Pageable pageable,int etat) {
		if( etat == 2) {//district
			if(utile.verifString(dataSearch.getLibellerSearch())) { 
				return vaccinCentreViewRep.findByIdVaccinAndIdRegionAndDistrictAndNomCentre(idvaccin, dataSearch.getIdRegion(),dataSearch.getIdDistrict(),dataSearch.getLibellerSearch().toLowerCase(),pageable);
			}else{ 
				return vaccinCentreViewRep.findByIdVaccinAndIdRegionAndDistrict(idvaccin, dataSearch.getIdRegion(),dataSearch.getIdDistrict(),pageable);
			}
		}else if( etat == 3) {//commune
			if(utile.verifString(dataSearch.getLibellerSearch())) { 
				return vaccinCentreViewRep.findByIdVaccinAndIdRegionAndDistrictAndCommuneAndNomCentre(idvaccin, dataSearch.getIdRegion(),dataSearch.getIdDistrict(),dataSearch.getIdCommune(),dataSearch.getLibellerSearch().toLowerCase(),pageable);
			}else{ 
				return vaccinCentreViewRep.findByIdVaccinAndIdRegionAndDistrictAndCommune(idvaccin, dataSearch.getIdRegion(),dataSearch.getIdDistrict(),dataSearch.getIdCommune(),pageable);
			}
		}else if( etat == 4) {//arrondissement
			if(utile.verifString(dataSearch.getLibellerSearch())) { 
				return vaccinCentreViewRep.findByIdVaccinAndIdRegionAndDistrictAndCommuneAndArrondissementAndNomCentre(idvaccin, dataSearch.getIdRegion(),dataSearch.getIdDistrict(),dataSearch.getIdCommune(),dataSearch.getIdArrindissement(),dataSearch.getLibellerSearch().toLowerCase(),pageable);
			}else{ 
				return vaccinCentreViewRep.findByIdVaccinAndIdRegionAndDistrictAndCommuneAndArrondissement(idvaccin, dataSearch.getIdRegion(),dataSearch.getIdDistrict(),dataSearch.getIdCommune(),dataSearch.getIdArrindissement(),pageable);
			}
		}else if( etat == 5) {//arrondissement
			if(utile.verifString(dataSearch.getLibellerSearch())) { 
				return vaccinCentreViewRep.findByIdVaccinAndIdRegionAndDistrictAndCommuneAndArrondissementAndFokontanyAndNomCentre(idvaccin, dataSearch.getIdRegion(),dataSearch.getIdDistrict(),dataSearch.getIdCommune(),dataSearch.getIdArrindissement(),dataSearch.getIdFokontany(),dataSearch.getLibellerSearch().toLowerCase(),pageable);
			}else{ 
				return vaccinCentreViewRep.findByIdVaccinAndIdRegionAndDistrictAndCommuneAndArrondissementAndFokontany(idvaccin, dataSearch.getIdRegion(),dataSearch.getIdDistrict(),dataSearch.getIdCommune(),dataSearch.getIdArrindissement(),dataSearch.getIdFokontany(),pageable);
			}
		}else{//region
			if(utile.verifString(dataSearch.getLibellerSearch())) { //region
				return vaccinCentreViewRep.findByIdVaccinAndIdRegionAndNomCentre(idvaccin, dataSearch.getIdRegion(),dataSearch.getLibellerSearch().toLowerCase(),pageable);
			}else{ 
				return vaccinCentreViewRep.findByIdVaccinAndIdRegion(idvaccin, dataSearch.getIdRegion(),pageable);
			}
		}
	}
	public Docs<VaccinCentreView> searchCentreVaccinationByFilter(DataSearch dataSearch) {
		if(dataSearch!=null && dataSearch.getIdvaccin()>0) {
			try {
				Page<VaccinCentreView> page = null;
				Pageable pageable = PageRequest.of(dataSearch.getPage(), dataSearch.getLimit(), Direction.ASC,"nom_vaccin"); int idvaccin = dataSearch.getIdvaccin();
				if(utile.verifString(dataSearch.getIdRegion())) { 
					if(utile.verifString(dataSearch.getIdDistrict())) {
						if(utile.verifString(dataSearch.getIdCommune())) { 
							if(utile.verifString(dataSearch.getIdArrindissement())) { 
								if(utile.verifString(dataSearch.getIdFokontany())) { 
									page = getData(idvaccin, dataSearch, pageable, 5);
								}else {
									page = getData(idvaccin, dataSearch, pageable, 4);
								}
							}else {
								page = getData(idvaccin, dataSearch, pageable, 3);
							}
						}else {
							page = getData(idvaccin, dataSearch, pageable, 2);
						}
					}else {
						page = getData(idvaccin, dataSearch, pageable, 1);
					}
				}else {
					return getPageableVaccinVaccinCentreViewByIdVaccin(dataSearch.getIdvaccin(),dataSearch.getLimit(),dataSearch.getPage(),dataSearch.getLibellerSearch());
				}
				if(page!=null) {
					Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
					return docs;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Docs<VaccinCentreView> docs = new Docs<VaccinCentreView>();docs.setDocs(new ArrayList<VaccinCentreView>());
		return docs;
	}
}
