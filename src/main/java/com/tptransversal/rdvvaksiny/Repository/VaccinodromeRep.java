package com.tptransversal.rdvvaksiny.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tptransversal.rdvvaksiny.model.Vaccinodrome;

@Repository
public interface VaccinodromeRep extends JpaRepository<Vaccinodrome, Integer> {
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccinodrome  WHERE email LIKE ?1 ")
	List<Vaccinodrome> findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true,value="UPDATE vaccinodrome SET mot_de_passe = ?2 WHERE idvaccinodrome = ?1 ")
	void modifierMotDePasseByIdVaccinodrome(int idvaccinodrome, String motDePasse);
}
