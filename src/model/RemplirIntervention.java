package model;

public class RemplirIntervention {
	private String nomMateriel, statutIntervention, descriptionProbleme,
			nomDemandeurIntervention, numTelDemandeurIntervention,
			dateDemandeIntervention, statutMateriel;

	public RemplirIntervention() {
		super();
	}

	public RemplirIntervention(String nomMateriel, String statutIntervention,
			String descriptionProbleme, String nomDemandeurIntervention,
			String numTelDemandeurIntervention, String dateDemandeIntervention,
			String statutMateriel) {
		super();
		this.nomMateriel = nomMateriel;
		this.statutIntervention = statutIntervention;
		this.descriptionProbleme = descriptionProbleme;
		this.nomDemandeurIntervention = nomDemandeurIntervention;
		this.numTelDemandeurIntervention = numTelDemandeurIntervention;
		this.dateDemandeIntervention = dateDemandeIntervention;
		this.statutMateriel = statutMateriel;
	}

	public String getNomMateriel() {
		return nomMateriel;
	}

	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
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

	public String getNomDemandeurIntervention() {
		return nomDemandeurIntervention;
	}

	public void setNomDemandeurIntervention(String nomDemandeurIntervention) {
		this.nomDemandeurIntervention = nomDemandeurIntervention;
	}

	public String getNumTelDemandeurIntervention() {
		return numTelDemandeurIntervention;
	}

	public void setNumTelDemandeurIntervention(
			String numTelDemandeurIntervention) {
		this.numTelDemandeurIntervention = numTelDemandeurIntervention;
	}

	public String getDateDemandeIntervention() {
		return dateDemandeIntervention;
	}

	public void setDateDemandeIntervention(String dateDemandeIntervention) {
		this.dateDemandeIntervention = dateDemandeIntervention;
	}

	public String getStatutMateriel() {
		return statutMateriel;
	}

	public void setStatutMateriel(String statutMateriel) {
		this.statutMateriel = statutMateriel;
	}

}
