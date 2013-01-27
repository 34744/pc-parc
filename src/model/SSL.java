package model;

public class SSL {
	private String nomSite, nomService, nomLocal;

	public SSL(String nomSite, String nomService, String nomLocal) {
		super();
		this.nomSite = nomSite;
		this.nomService = nomService;
		this.nomLocal = nomLocal;
	}

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public String getNomLocal() {
		return nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}

}
