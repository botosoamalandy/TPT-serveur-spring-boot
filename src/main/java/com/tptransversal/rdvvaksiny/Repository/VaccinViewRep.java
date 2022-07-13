package com.tptransversal.rdvvaksiny.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tptransversal.rdvvaksiny.model.VaccinView;

@Repository
public interface VaccinViewRep extends JpaRepository<VaccinView, Integer> {
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccinview WHERE status = 1 ")
	Page<VaccinView> findByStatusSort(Pageable pages);
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccinview WHERE lower(nom_vaccin) LIKE %?1% ")
	Page<VaccinView> findByNom_vaccinSort(String nom_vaccin,Pageable pages);
}
