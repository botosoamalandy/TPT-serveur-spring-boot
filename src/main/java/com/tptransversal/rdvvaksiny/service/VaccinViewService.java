package com.tptransversal.rdvvaksiny.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tptransversal.rdvvaksiny.Repository.VaccinViewRep;
import com.tptransversal.rdvvaksiny.model.Docs;
import com.tptransversal.rdvvaksiny.model.VaccinView;

@Service
public class VaccinViewService {
	
	@Autowired
	VaccinViewRep vaccinViewRep;
	

	public Docs<VaccinView> getPageableVaccinView(int limit,int pageNumber) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<VaccinView> page = vaccinViewRep.findByStatusSort(PageRequest.of(pageNumber, limit, Direction.ASC,"nom_vaccin"));
				Docs<VaccinView> docs = new Docs<VaccinView>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		Docs<VaccinView> docs = new Docs<VaccinView>();docs.setDocs(new ArrayList<VaccinView>());
		return docs;
	}
	public Docs<VaccinView> getPageableVaccinViewSearch(int limit,int pageNumber,String libeller) {
		if(limit>0 && pageNumber>=0) {
			try {
				Page<VaccinView> page = vaccinViewRep.findByNom_vaccinSort(libeller.toLowerCase(),PageRequest.of(pageNumber, limit, Direction.ASC,"nom_vaccin"));
				Docs<VaccinView> docs = new Docs<VaccinView>(page.getContent(),page.getNumberOfElements(),(int)page.getPageable().getOffset(),page.getPageable().getPageNumber(),page.getTotalPages(),1,page.hasPrevious(),page.hasNext(),page.getPageable().getPageNumber()-1,page.getPageable().getPageNumber()+1);
				return docs;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Docs<VaccinView> docs = new Docs<VaccinView>();docs.setDocs(new ArrayList<VaccinView>());
		return docs;
		
	}

}
