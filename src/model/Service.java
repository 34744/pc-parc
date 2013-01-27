package model;

public class Service {
	private String nomService, libelleServiceFR, libelleServiceNL, fkSite;

	public Service(String nomService, String libelleServiceFR,
			String libelleServiceNL, String fkSite) {
		super();
		this.nomService = nomService;
		this.libelleServiceFR = libelleServiceFR;
		this.libelleServiceNL = libelleServiceNL;
		this.fkSite = fkSite;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public String getLibelleServiceFR() {
		return libelleServiceFR;
	}

	public void setLibelleServiceFR(String libelleServiceFR) {
		this.libelleServiceFR = libelleServiceFR;
	}

	public String getLibelleServiceNL() {
		return libelleServiceNL;
	}

	public void setLibelleServiceNL(String libelleServiceNL) {
		this.libelleServiceNL = libelleServiceNL;
	}

	public String getFkSite() {
		return fkSite;
	}

	public void setFkSite(String fkSite) {
		this.fkSite = fkSite;
	}

}
