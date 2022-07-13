package com.tptransversal.rdvvaksiny.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tptransversal.rdvvaksiny.model.VaccinCentre;

@Repository
public interface VaccinCentreRep extends JpaRepository<VaccinCentre, Integer> {
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccincentre WHERE idvaccinodrome=?1 and idvaccin=?2")
	List<VaccinCentre> findByIdvaccinodromeAndIdvaccin(int idvaccinodrome,int idvaccin);
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccincentre WHERE idvaccincentre=?1")
	List<VaccinCentre> findByIdVaccinCentre(int idvaccinodrome);
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true,value="delete vaccincentre WHERE idvaccincentre = ?1")
	void deleteVaccinCentreByidVaccinCentre(int idvaccincentre);
}
