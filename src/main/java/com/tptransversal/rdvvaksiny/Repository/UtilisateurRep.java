package com.tptransversal.rdvvaksiny.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tptransversal.rdvvaksiny.model.Utilisateur;

@Repository
public interface UtilisateurRep extends JpaRepository<Utilisateur, Integer>{
	
	@Query(nativeQuery=true,value="SELECT * FROM utilisateur  WHERE telephone LIKE %?1% and status=1 ")
	List<Utilisateur> findByTelephone(String tel);
	
	@Query(nativeQuery=true,value="SELECT * FROM utilisateur WHERE lower(email) LIKE %?1% and telephone LIKE %?2% and status=1 ")
	List<Utilisateur> findByEmailAndTelephone(String email,String telephone);
	
}
