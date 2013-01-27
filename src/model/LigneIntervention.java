package model;

public class LigneIntervention {

	private int idLigneIntervention, fkSocieteExtLI, fkIntervention;
	private String descriptionLigneIntervention, dateLigneIntervention,
			fkTechnicien;

	public LigneIntervention() {
		super();
	}

	public LigneIntervention(int idLigneIntervention, int fkSocieteExtLI,
			int fkIntervention, String descriptionLigneIntervention,
			String dateLigneIntervention, String fkTechnicien) {
		super();
		this.idLigneIntervention = idLigneIntervention;
		this.fkSocieteExtLI = fkSocieteExtLI;
		this.fkIntervention = fkIntervention;
		this.descriptionLigneIntervention = descriptionLigneIntervention;
		this.dateLigneIntervention = dateLigneIntervention;
		this.fkTechnicien = fkTechnicien;
	}

	public int getIdLigneIntervention() {
		return idLigneIntervention;
	}

	public void setIdLigneIntervention(int idLigneIntervention) {
		this.idLigneIntervention = idLigneIntervention;
	}

	public int getFkSocieteExtLI() {
		return fkSocieteExtLI;
	}

	public void setFkSocieteExtLI(int fkSocieteExtLI) {
		this.fkSocieteExtLI = fkSocieteExtLI;
	}

	public int getFkIntervention() {
		return fkIntervention;
	}

	public void setFkIntervention(int fkIntervention) {
		this.fkIntervention = fkIntervention;
	}

	public String getDescriptionLigneIntervention() {
		return descriptionLigneIntervention;
	}

	public void setDescriptionLigneIntervention(
			String descriptionLigneIntervention) {
		this.descriptionLigneIntervention = descriptionLigneIntervention;
	}

	public String getDateLigneIntervention() {
		return dateLigneIntervention;
	}

	public void setDateLigneIntervention(String dateLigneIntervention) {
		this.dateLigneIntervention = dateLigneIntervention;
	}

	public String getFkTechnicien() {
		return fkTechnicien;
	}

	public void setFkTechnicien(String fkTechnicien) {
		this.fkTechnicien = fkTechnicien;
	}

}
