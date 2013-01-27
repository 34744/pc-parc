package model;

public class Marque {

	private int idNomMarque;
	private String nomMarque, siteInternetMarque;

	public Marque(int idNomMarque, String nomMarque, String siteInternetMarque) {
		super();
		this.idNomMarque = idNomMarque;
		this.nomMarque = nomMarque;
		this.siteInternetMarque = siteInternetMarque;
	}

	public int getIdNomMarque() {
		return idNomMarque;
	}

	public void setIdNomMarque(int idNomMarque) {
		this.idNomMarque = idNomMarque;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public String getSiteInternetMarque() {
		return siteInternetMarque;
	}

	public void setSiteInternetMarque(String siteInternetMarque) {
		this.siteInternetMarque = siteInternetMarque;
	}

}
