package model;

public class MaterielArbre {

	private String NomMateriel, NumSerieMateriel, DateAchat, DateInstallation,
			statutMateriel, AdresseMac, AdresseIp, noteMateriel, NomService,
			NomSite, NomModeleMateriel, nomTypeMateriel, NomMarque, fkImageW,
			FkBudget, LibelleServiceFR, nomLocal;
	private int DureeGarantie;

	public MaterielArbre() {
		super();
	}

	public MaterielArbre(String nomMateriel, String numSerieMateriel,
			String dateAchat, String dateInstallation, String statutMateriel,
			String adresseMac, String adresseIp, String noteMateriel,
			String nomService, String nomSite, String nomModeleMateriel,
			String nomTypeMateriel, String nomMarque, String fkImageW,
			String fkBudget, String libelleServiceFR, String nomLocal,
			int dureeGarantie) {
		super();
		NomMateriel = nomMateriel;
		NumSerieMateriel = numSerieMateriel;
		DateAchat = dateAchat;
		DateInstallation = dateInstallation;
		this.statutMateriel = statutMateriel;
		AdresseMac = adresseMac;
		AdresseIp = adresseIp;
		this.noteMateriel = noteMateriel;
		NomService = nomService;
		NomSite = nomSite;
		NomModeleMateriel = nomModeleMateriel;
		this.nomTypeMateriel = nomTypeMateriel;
		NomMarque = nomMarque;
		this.fkImageW = fkImageW;
		FkBudget = fkBudget;
		LibelleServiceFR = libelleServiceFR;
		this.nomLocal = nomLocal;
		DureeGarantie = dureeGarantie;
	}

	public String getNomMateriel() {
		return NomMateriel;
	}

	public void setNomMateriel(String nomMateriel) {
		NomMateriel = nomMateriel;
	}

	public String getNumSerieMateriel() {
		return NumSerieMateriel;
	}

	public void setNumSerieMateriel(String numSerieMateriel) {
		NumSerieMateriel = numSerieMateriel;
	}

	public String getDateAchat() {
		return DateAchat;
	}

	public void setDateAchat(String dateAchat) {
		DateAchat = dateAchat;
	}

	public String getDateInstallation() {
		return DateInstallation;
	}

	public void setDateInstallation(String dateInstallation) {
		DateInstallation = dateInstallation;
	}

	public String getStatutMateriel() {
		return statutMateriel;
	}

	public void setStatutMateriel(String statutMateriel) {
		this.statutMateriel = statutMateriel;
	}

	public String getAdresseMac() {
		return AdresseMac;
	}

	public void setAdresseMac(String adresseMac) {
		AdresseMac = adresseMac;
	}

	public String getAdresseIp() {
		return AdresseIp;
	}

	public void setAdresseIp(String adresseIp) {
		AdresseIp = adresseIp;
	}

	public String getNoteMateriel() {
		return noteMateriel;
	}

	public void setNoteMateriel(String noteMateriel) {
		this.noteMateriel = noteMateriel;
	}

	public String getNomService() {
		return NomService;
	}

	public void setNomService(String nomService) {
		NomService = nomService;
	}

	public String getNomSite() {
		return NomSite;
	}

	public void setNomSite(String nomSite) {
		NomSite = nomSite;
	}

	public String getNomModeleMateriel() {
		return NomModeleMateriel;
	}

	public void setNomModeleMateriel(String nomModeleMateriel) {
		NomModeleMateriel = nomModeleMateriel;
	}

	public String getNomTypeMateriel() {
		return nomTypeMateriel;
	}

	public void setNomTypeMateriel(String nomTypeMateriel) {
		this.nomTypeMateriel = nomTypeMateriel;
	}

	public String getNomMarque() {
		return NomMarque;
	}

	public void setNomMarque(String nomMarque) {
		NomMarque = nomMarque;
	}

	public String getFkImageW() {
		return fkImageW;
	}

	public void setFkImageW(String fkImageW) {
		this.fkImageW = fkImageW;
	}

	public String getFkBudget() {
		return FkBudget;
	}

	public void setFkBudget(String fkBudget) {
		FkBudget = fkBudget;
	}

	public String getLibelleServiceFR() {
		return LibelleServiceFR;
	}

	public void setLibelleServiceFR(String libelleServiceFR) {
		LibelleServiceFR = libelleServiceFR;
	}

	public String getNomLocal() {
		return nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}

	public int getDureeGarantie() {
		return DureeGarantie;
	}

	public void setDureeGarantie(int dureeGarantie) {
		DureeGarantie = dureeGarantie;
	}

}
