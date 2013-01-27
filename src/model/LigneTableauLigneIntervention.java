package model;

public class LigneTableauLigneIntervention {



	private int idLigneIntervention;
	private String dateLigneIntervention, nom, DescriptionLigneIntervention;

	public LigneTableauLigneIntervention(int idLigneIntervention,
			String dateLigneIntervention, String nom,
			String descriptionLigneIntervention) {
		super();
		this.idLigneIntervention = idLigneIntervention;
		this.dateLigneIntervention = dateLigneIntervention;
		this.nom = nom;
		DescriptionLigneIntervention = descriptionLigneIntervention;
	}

	public int getIdLigneIntervention() {
		return idLigneIntervention;
	}

	public void setIdLigneIntervention(int idLigneIntervention) {
		this.idLigneIntervention = idLigneIntervention;
	}

	public String getDateLigneIntervention() {
		return dateLigneIntervention;
	}

	public void setDateLigneIntervention(String dateLigneIntervention) {
		this.dateLigneIntervention = dateLigneIntervention;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescriptionLigneIntervention() {
		return DescriptionLigneIntervention;
	}

	public void setDescriptionLigneIntervention(
			String descriptionLigneIntervention) {
		DescriptionLigneIntervention = descriptionLigneIntervention;
	}

	public LigneTableauLigneIntervention() {
		super();
	}
	
	@Override
	public String toString() {
		return "LigneTableauLigneIntervention [idLigneIntervention="
				+ idLigneIntervention + ", dateLigneIntervention="
				+ dateLigneIntervention + ", nom=" + nom
				+ ", DescriptionLigneIntervention="
				+ DescriptionLigneIntervention + "]";
	}

}
