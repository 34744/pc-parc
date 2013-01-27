package model;

public class LigneTableauIntervention {

	int idIntervention;
	private String statutIntervention, descriptionProbleme, dateIntervention,
			nomMateriel, nomSite, nomService, typeMateriel;

	public LigneTableauIntervention() {
		super();
	}

	public LigneTableauIntervention(int idIntervention,
			String statutIntervention, String descriptionProbleme,
			String dateIntervention, String nomMateriel, String nomSite,
			String nomService, String typeMateriel) {
		super();
		this.idIntervention = idIntervention;
		this.statutIntervention = statutIntervention;
		this.descriptionProbleme = descriptionProbleme;
		this.dateIntervention = dateIntervention;
		this.nomMateriel = nomMateriel;
		this.nomSite = nomSite;
		this.nomService = nomService;
		this.typeMateriel = typeMateriel;
	}

	public int getIdIntervention() {
		return idIntervention;
	}

	public void setIdIntervention(int idIntervention) {
		this.idIntervention = idIntervention;
	}

	public String getStatutIntervention() {
		return statutIntervention;
	}

	public void setStatutIntervention(String statutIntervention) {
		this.statutIntervention = statutIntervention;
	}

	public String getDescriptionProbleme() {
		return descriptionProbleme;
	}

	public void setDescriptionProbleme(String descriptionProbleme) {
		this.descriptionProbleme = descriptionProbleme;
	}

	public String getDateIntervention() {
		return dateIntervention;
	}

	public void setDateIntervention(String dateIntervention) {
		this.dateIntervention = dateIntervention;
	}

	public String getNomMateriel() {
		return nomMateriel;
	}

	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
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

	public String getTypeMateriel() {
		return typeMateriel;
	}

	public void setTypeMateriel(String typeMateriel) {
		this.typeMateriel = typeMateriel;
	}

}
