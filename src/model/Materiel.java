package model;

import java.util.Date;
import java.util.GregorianCalendar;

public class Materiel {

	private String nomMateriel, numSerieMateriel, statutMateriel, adresseIp,
			adresseMac, noteMateriel, fkMateriel, fkDomaineReseau, fkBudget,
			fkImageW;
	private int dureeGarantie, fkModeleMateriel, fkLocalS,fkSocieteExt;
	private String dateAchat, dateInstallation;

	public Materiel() {
		super();
	}

	public Materiel(String nomMateriel, String numSerieMateriel,
			String statutMateriel, String adresseIp, String adresseMac,
			String noteMateriel, String fkMateriel, String fkDomaineReseau,
			String fkBudget, String fkImageW, int dureeGarantie,
			int fkModeleMateriel, int fkLocalS, String dateAchat,
			String dateInstallation, int fkSocieteExt) {
		super();
		this.nomMateriel = nomMateriel;
		this.numSerieMateriel = numSerieMateriel;
		this.statutMateriel = statutMateriel;
		this.adresseIp = adresseIp;
		this.adresseMac = adresseMac;
		this.noteMateriel = noteMateriel;
		this.fkMateriel = fkMateriel;
		this.fkDomaineReseau = fkDomaineReseau;
		this.fkBudget = fkBudget;
		this.fkImageW = fkImageW;
		this.dureeGarantie = dureeGarantie;
		this.fkModeleMateriel = fkModeleMateriel;
		this.fkLocalS = fkLocalS;
		this.dateAchat = dateAchat;
		this.dateInstallation = dateInstallation;
		this.fkSocieteExt = fkSocieteExt;
	}

	public String getNomMateriel() {
		return nomMateriel;
	}

	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}

	public String getNumSerieMateriel() {
		return numSerieMateriel;
	}

	public void setNumSerieMateriel(String numSerieMateriel) {
		this.numSerieMateriel = numSerieMateriel;
	}

	public String getStatutMateriel() {
		return statutMateriel;
	}

	public void setStatutMateriel(String statutMateriel) {
		this.statutMateriel = statutMateriel;
	}

	public String getAdresseIp() {
		return adresseIp;
	}

	public void setAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}

	public String getAdresseMac() {
		return adresseMac;
	}

	public void setAdresseMac(String adresseMac) {
		this.adresseMac = adresseMac;
	}

	public String getNoteMateriel() {
		return noteMateriel;
	}

	public void setNoteMateriel(String noteMateriel) {
		this.noteMateriel = noteMateriel;
	}

	public String getFkMateriel() {
		return fkMateriel;
	}

	public void setFkMateriel(String fkMateriel) {
		this.fkMateriel = fkMateriel;
	}

	public String getFkDomaineReseau() {
		return fkDomaineReseau;
	}

	public void setFkDomaineReseau(String fkDomaineReseau) {
		this.fkDomaineReseau = fkDomaineReseau;
	}

	public String getFkBudget() {
		return fkBudget;
	}

	public void setFkBudget(String fkBudget) {
		this.fkBudget = fkBudget;
	}

	public String getFkImageW() {
		return fkImageW;
	}

	public void setFkImageW(String fkImageW) {
		this.fkImageW = fkImageW;
	}

	public int getDureeGarantie() {
		return dureeGarantie;
	}

	public void setDureeGarantie(int dureeGarantie) {
		this.dureeGarantie = dureeGarantie;
	}

	public int getFkModeleMateriel() {
		return fkModeleMateriel;
	}

	public void setFkModeleMateriel(int fkModeleMateriel) {
		this.fkModeleMateriel = fkModeleMateriel;
	}

	public int getFkLocalS() {
		return fkLocalS;
	}

	public void setFkLocalS(int fkLocalS) {
		this.fkLocalS = fkLocalS;
	}

	public String getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(String dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getDateInstallation() {
		return dateInstallation;
	}

	public void setDateInstallation(String dateInstallation) {
		this.dateInstallation = dateInstallation;
	}

	public int getFkSocieteExt() {
		return fkSocieteExt;
	}

	public void setFkSocieteExt(int fkSocieteExt) {
		this.fkSocieteExt = fkSocieteExt;
	}

	@Override
	public String toString() {
		return "Materiel [nomMateriel=" + nomMateriel + ", numSerieMateriel="
				+ numSerieMateriel + ", statutMateriel=" + statutMateriel
				+ ", adresseIp=" + adresseIp + ", adresseMac=" + adresseMac
				+ ", noteMateriel=" + noteMateriel + ", fkMateriel="
				+ fkMateriel + ", fkDomaineReseau=" + fkDomaineReseau
				+ ", fkBudget=" + fkBudget + ", fkImageW=" + fkImageW
				+ ", dureeGarantie=" + dureeGarantie + ", fkModeleMateriel="
				+ fkModeleMateriel + ", fkLocalS=" + fkLocalS
				+ ", fkSocieteExt=" + fkSocieteExt + ", dateAchat=" + dateAchat
				+ ", dateInstallation=" + dateInstallation + "]";
	}

	

}
