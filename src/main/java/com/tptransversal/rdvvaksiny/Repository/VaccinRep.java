package com.tptransversal.rdvvaksiny.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tptransversal.rdvvaksiny.model.Vaccin;

@Repository
public interface VaccinRep extends JpaRepository<Vaccin, Integer> {
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccin WHERE  idvaccin = ?1 and status = 1 ")
	Vaccin findByIdVaccin(int idvaccin);
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccin WHERE  lower(nom_vaccin) LIKE %?1% and status = 1 ")
	List<Vaccin> findByNomVaccin(String nom_vaccin);
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccin WHERE status = 1 ")
	Page<Vaccin> findByStatusSort(Pageable pages);
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccin WHERE lower(nom_vaccin) LIKE %?1% and status = 1 ")
	Page<Vaccin> findByNom_vaccinSort(String nom_vaccin,Pageable pages);
	
}
