package com.tptransversal.rdvvaksiny.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tptransversal.rdvvaksiny.model.Cormobidite;

@Repository
public interface CormobiditeRep extends JpaRepository<Cormobidite, Integer>{

}
