package model;

public class SocieteExt {
	private int idSocieteExt;
	private String nomSocieteExt, adresseSocieteExt, numTvaSocieteExt,
			typeSocieteExt, siteWebSocieteExt;
	private boolean actif;

	public SocieteExt(int idSocieteExt, String nomSocieteExt,
			String adresseSocieteExt, String numTvaSocieteExt,
			String typeSocieteExt, String siteWebSocieteExt, boolean actif) {
		super();
		this.idSocieteExt = idSocieteExt;
		this.nomSocieteExt = nomSocieteExt;
		this.adresseSocieteExt = adresseSocieteExt;
		this.numTvaSocieteExt = numTvaSocieteExt;
		this.typeSocieteExt = typeSocieteExt;
		this.siteWebSocieteExt = siteWebSocieteExt;
		this.actif = actif;
	}

	public SocieteExt(int idSocieteExt, String nomSocieteExt) {
		super();
		this.idSocieteExt = idSocieteExt;
		this.nomSocieteExt = nomSocieteExt;
	}

	public int getIdSocieteExt() {
		return idSocieteExt;
	}

	public void setIdSocieteExt(int idSocieteExt) {
		this.idSocieteExt = idSocieteExt;
	}

	public String getNomSocieteExt() {
		return nomSocieteExt;
	}

	public void setNomSocieteExt(String nomSocieteExt) {
		this.nomSocieteExt = nomSocieteExt;
	}

	public String getAdresseSocieteExt() {
		return adresseSocieteExt;
	}

	public void setAdresseSocieteExt(String adresseSocieteExt) {
		this.adresseSocieteExt = adresseSocieteExt;
	}

	public String getNumTvaSocieteExt() {
		return numTvaSocieteExt;
	}

	public void setNumTvaSocieteExt(String numTvaSocieteExt) {
		this.numTvaSocieteExt = numTvaSocieteExt;
	}

	public String getTypeSocieteExt() {
		return typeSocieteExt;
	}

	public void setTypeSocieteExt(String typeSocieteExt) {
		this.typeSocieteExt = typeSocieteExt;
	}

	public String getSiteWebSocieteExt() {
		return siteWebSocieteExt;
	}

	public void setSiteWebSocieteExt(String siteWebSocieteExt) {
		this.siteWebSocieteExt = siteWebSocieteExt;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

}
