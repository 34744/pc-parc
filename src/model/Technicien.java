package model;

public class Technicien {

	private String idTechnicien, nomTechnicien, prenomTechnicien,
			numTelTechnicien;
	private Boolean actifTechnicien;

	public Technicien(String idTechnicien, String nomTechnicien,
			String prenomTechnicien, String numTelTechnicien,
			Boolean actifTechnicien) {
		super();
		this.idTechnicien = idTechnicien;
		this.nomTechnicien = nomTechnicien;
		this.prenomTechnicien = prenomTechnicien;
		this.numTelTechnicien = numTelTechnicien;
		this.actifTechnicien = actifTechnicien;
	}

	public String getIdTechnicien() {
		return idTechnicien;
	}

	public void setIdTechnicien(String idTechnicien) {
		this.idTechnicien = idTechnicien;
	}

	public String getNomTechnicien() {
		return nomTechnicien;
	}

	public void setNomTechnicien(String nomTechnicien) {
		this.nomTechnicien = nomTechnicien;
	}

	public String getPrenomTechnicien() {
		return prenomTechnicien;
	}

	public void setPrenomTechnicien(String prenomTechnicien) {
		this.prenomTechnicien = prenomTechnicien;
	}

	public String getNumTelTechnicien() {
		return numTelTechnicien;
	}

	public void setNumTelTechnicien(String numTelTechnicien) {
		this.numTelTechnicien = numTelTechnicien;
	}

	public Boolean getActifTechnicien() {
		return actifTechnicien;
	}

	public void setActifTechnicien(Boolean actifTechnicien) {
		this.actifTechnicien = actifTechnicien;
	}

}
