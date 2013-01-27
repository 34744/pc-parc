package model;

public class Site {
	private String codeSite, nomSite, adresseSite;

	public Site(String codeSite, String nomSite, String adresseSite) {
		super();
		this.codeSite = codeSite;
		this.nomSite = nomSite;
		this.adresseSite = adresseSite;
	}

	public String getCodeSite() {
		return codeSite;
	}

	public void setCodeSite(String codeSite) {
		this.codeSite = codeSite;
	}

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getAdresseSite() {
		return adresseSite;
	}

	public void setAdresseSite(String adresseSite) {
		adresseSite = adresseSite;
	}

}
