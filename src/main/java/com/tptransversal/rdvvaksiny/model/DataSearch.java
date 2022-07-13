package com.tptransversal.rdvvaksiny.model;

public class DataSearch {
	String idRegion = "";
	String idDistrict = "";
	String idCommune = "";
	String idArrindissement = "";
	String idFokontany = "";
	String libellerSearch = "";
	int idvaccin = 0;
    int page = 0;
    int limit = 10;
    
    public DataSearch() {}

	public DataSearch(String idRegion, String idDistrict, String idCommune, String idArrindissement, String idFokontany,String libellerSearch, int idvaccin, int page,int limit) {
		this.idRegion = idRegion;
		this.idDistrict = idDistrict;
		this.idCommune = idCommune;
		this.idArrindissement = idArrindissement;
		this.idFokontany = idFokontany;
		this.libellerSearch = libellerSearch;
		this.idvaccin = idvaccin;
		this.page = page;
		this.limit = limit;
	}

	public String getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}

	public String getIdDistrict() {
		return idDistrict;
	}

	public void setIdDistrict(String idDistrict) {
		this.idDistrict = idDistrict;
	}

	public String getIdCommune() {
		return idCommune;
	}

	public void setIdCommune(String idCommune) {
		this.idCommune = idCommune;
	}

	public String getIdArrindissement() {
		return idArrindissement;
	}

	public void setIdArrindissement(String idArrindissement) {
		this.idArrindissement = idArrindissement;
	}

	public String getIdFokontany() {
		return idFokontany;
	}

	public void setIdFokontany(String idFokontany) {
		this.idFokontany = idFokontany;
	}

	public String getLibellerSearch() {
		return libellerSearch;
	}

	public void setLibellerSearch(String libellerSearch) {
		this.libellerSearch = libellerSearch;
	}
	
	public int getIdvaccin() {
		return idvaccin;
	}

	public void setIdvaccin(int idvaccin) {
		this.idvaccin = idvaccin;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
    
    
}
