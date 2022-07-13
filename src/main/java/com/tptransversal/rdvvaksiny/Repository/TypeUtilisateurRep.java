package com.tptransversal.rdvvaksiny.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tptransversal.rdvvaksiny.model.TypeUtilisateur;


public interface TypeUtilisateurRep extends JpaRepository<TypeUtilisateur, Integer>{
	
	@Query(nativeQuery=true,value="SELECT * FROM typeutilisateur WHERE idtypeutilisateur = ?1 ")
	TypeUtilisateur findByIdtypeutilisateur(String idtypeutilisateur);
}
