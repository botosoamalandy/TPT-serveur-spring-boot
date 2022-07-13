package com.tptransversal.rdvvaksiny.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tptransversal.rdvvaksiny.model.InfoVaccinUser;

@Repository
public interface InfoVaccinUserRep extends JpaRepository<InfoVaccinUser, Integer> {

}
