package com.tptransversal.rdvvaksiny.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tptransversal.rdvvaksiny.model.Maladie;


@Repository
public interface MaladieRep extends JpaRepository<Maladie, Integer> {
	
	@Query(nativeQuery=true,value="SELECT * FROM maladie  WHERE maladie LIKE ?1 and status = 1 ")
	List<Maladie> findByMaladie(String maladie);
	
	@Query(nativeQuery=true,value="select * from maladie where idmaladie in (select idmaladie from cormobidite where idvaccin = ?1 ) and status = 1 and rownum <=5 ")
	List<Maladie> findByIdVaccin(int idvaccin);
	
	@Query(nativeQuery=true,value="SELECT * FROM maladie WHERE lower(maladie) LIKE %?1% and status = 1 ")
	Page<Maladie> findByMaladieSort(String maladie,Pageable pages);
	
	@Query(nativeQuery=true,value="SELECT * FROM maladie WHERE status = 1 ")
	Page<Maladie> findByStatusSort(Pageable pages);
	
	@Query(nativeQuery=true,value="select * from maladie where idmaladie in (select idmaladie from cormobidite where idvaccin = ?1 ) and status = 1 and rownum <=5 ")
	Page<Maladie> findByIdVaccinSort(int idvaccin,Pageable pages);

	
	@Query(nativeQuery=true,value="SELECT * FROM maladie WHERE  idmaladie = ?1 and status = 1 ")
	Maladie findByIdMaladie(int idmaladie);
}
