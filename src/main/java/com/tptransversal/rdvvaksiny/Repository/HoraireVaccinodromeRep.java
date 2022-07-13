package com.tptransversal.rdvvaksiny.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tptransversal.rdvvaksiny.model.HoraireVaccinodrome;


@Repository
public interface HoraireVaccinodromeRep extends JpaRepository<HoraireVaccinodrome, Integer>  {
	
}
