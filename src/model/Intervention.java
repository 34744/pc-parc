package model;

public class Intervention {
	private int idIntervention;
	private String statutIntervention, DescriptionProbleme,
			nomDemandeurIntervention, numTelDemandeurIntervention,
			dateDemandeIntervention, fkMateriel;

	public Intervention() {
		super();
	}

	public Intervention(int idIntervention, String statutIntervention,
			String descriptionProbleme, String nomDemandeurIntervention,
			String numTelDemandeurIntervention, String dateDemandeIntervention,
			String fkMateriel) {
		super();
		this.idIntervention = idIntervention;
		this.statutIntervention = statutIntervention;
		DescriptionProbleme = descriptionProbleme;
		this.nomDemandeurIntervention = nomDemandeurIntervention;
		this.numTelDemandeurIntervention = numTelDemandeurIntervention;
		this.dateDemandeIntervention = dateDemandeIntervention;
		this.fkMateriel = fkMateriel;
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
		return DescriptionProbleme;
	}

	public void setDescriptionProbleme(String descriptionProbleme) {
		DescriptionProbleme = descriptionProbleme;
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

	public String getFkMateriel() {
		return fkMateriel;
	}

	public void setFkMateriel(String fkMateriel) {
		this.fkMateriel = fkMateriel;
	}

	@Override
	public String toString() {
		return "Intervention [idIntervention=" + idIntervention
				+ ", statutIntervention=" + statutIntervention
				+ ", DescriptionProbleme=" + DescriptionProbleme
				+ ", nomDemandeurIntervention=" + nomDemandeurIntervention
				+ ", numTelDemandeurIntervention="
				+ numTelDemandeurIntervention + ", dateDemandeIntervention="
				+ dateDemandeIntervention + ", fkMateriel=" + fkMateriel + "]";
	}

}
