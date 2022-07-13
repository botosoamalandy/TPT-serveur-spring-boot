package com.tptransversal.rdvvaksiny.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tptransversal.rdvvaksiny.model.VaccinCentreView;

@Repository
public interface VaccinCentreViewRep extends JpaRepository<VaccinCentreView, Integer> {
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccincentreview WHERE idvaccinodrome=?1 ")
	Page<VaccinCentreView> findByIdVaccinodromeSort(int idvaccinodrome,Pageable pages);
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccincentreview WHERE idvaccinodrome=?1 and lower(nom_vaccin) LIKE %?2% ")
	Page<VaccinCentreView> findByIdVaccinodromeAndNom_vaccinSort(int idvaccinodrome,String nom_vaccin,Pageable pages);

	@Query(nativeQuery=true,value="SELECT * FROM vaccincentreview WHERE idvaccin=?1 ")
	Page<VaccinCentreView> findByIdVaccinoSort(int idvaccin,Pageable pages);
	
	@Query(nativeQuery=true,value="SELECT * FROM vaccincentreview WHERE idvaccin=?1 and lower(nom_centre) LIKE %?2% ")
	Page<VaccinCentreView> findByIdVaccinAndNom_vaccinSort(int idvaccin,String nom_vaccin,Pageable pages);
	
	//region
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 )")
	Page<VaccinCentreView> findByIdVaccinAndIdRegion(int idvaccin,String idregion,Pageable pages);
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 and lower(nom_centre) LIKE %?3% )")
	Page<VaccinCentreView> findByIdVaccinAndIdRegionAndNomCentre(int idvaccin,String idregion,String nomCentre,Pageable pages);
	
	//region et district
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 and iddistrict = ?3 )")
	Page<VaccinCentreView> findByIdVaccinAndIdRegionAndDistrict(int idvaccin,String idregion,String idDistrict,Pageable pages);
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 and iddistrict = ?3 and lower(nom_centre) LIKE %?4% )")
	Page<VaccinCentreView> findByIdVaccinAndIdRegionAndDistrictAndNomCentre(int idvaccin,String idregion,String idDistrict,String nomCentre,Pageable pages);
	
	//region et district et commune
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 and iddistrict = ?3  and idcommune = ?4)")
	Page<VaccinCentreView> findByIdVaccinAndIdRegionAndDistrictAndCommune(int idvaccin,String idregion,String idDistrict,String idCommune,Pageable pages);
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 and iddistrict = ?3"
			+ "  and idcommune = ?4 and lower(nom_centre) LIKE %?5% )")
	Page<VaccinCentreView> findByIdVaccinAndIdRegionAndDistrictAndCommuneAndNomCentre(int idvaccin,String idregion,String idDistrict,String idCommune,String nomCentre,Pageable pages);
	
	//region et district et commune et arrondissement
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 and iddistrict = ?3 "
			+ " and idcommune = ?4 and idarrindissement = ?5)")
	Page<VaccinCentreView> findByIdVaccinAndIdRegionAndDistrictAndCommuneAndArrondissement(int idvaccin,String idregion,String idDistrict,String idCommune,String idrrondissement,Pageable pages);
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 and iddistrict = ?3"
			+ "  and idcommune = ?4 and idarrindissement = ?5  and lower(nom_centre) LIKE %?6% )")
	Page<VaccinCentreView> findByIdVaccinAndIdRegionAndDistrictAndCommuneAndArrondissementAndNomCentre(int idvaccin,String idregion,String idDistrict,String idCommune,String idrrondissement,String nomCentre,Pageable pages);
	
	
	//region et district et commune et arrondissement
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 and iddistrict = ?3 "
			+ " and idcommune = ?4 and idarrindissement = ?5 and idfokontany = ?6)")
	Page<VaccinCentreView> findByIdVaccinAndIdRegionAndDistrictAndCommuneAndArrondissementAndFokontany(int idvaccin,String idregion,String idDistrict,String idCommune,String idrrondissement,String fokontany,Pageable pages);
	@Query(nativeQuery=true,value="select * from vaccincentreview where idvaccin = ?1 and idvaccinodrome in (select idvaccinodrome from vaccinodrome where idregion= ?2 and iddistrict = ?3"
			+ "  and idcommune = ?4 and idarrindissement = ?5 and idfokontany = ?6 and lower(nom_centre) LIKE %?7% )")
	Page<VaccinCentreView> findByIdVaccinAndIdRegionAndDistrictAndCommuneAndArrondissementAndFokontanyAndNomCentre(int idvaccin,String idregion,String idDistrict,String idCommune,String idrrondissement,String fokontany,String nomCentre,Pageable pages);
	

}
